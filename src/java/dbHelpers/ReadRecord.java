/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dogs;

/**
 *
 * @author baileykrebs
 */
public class ReadRecord {
    
    
    private Connection conn;
    private ResultSet results;
    
    private Dogs dog= new Dogs();
    private int dogID;
    
    
    public ReadRecord (int dogID) {
    
    Properties propa= new Properties();
       InputStream instr=getClass().getResourceAsStream("dbConn.properties");
        try {
            propa.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String driver= propa.getProperty("driver.name");
       String url= propa.getProperty("server.name");
       String username= propa.getProperty("user.name");
       String passwd= propa.getProperty("user.password");
       
       this.dogID=dogID;
       
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    
    public void doRead() {
    
        try {
            //set up a string to hold our query
            String query= "SELECT * FROM dogs WHERE dogID = ?";
            
            //create a preparedStatement using query
            
            PreparedStatement ps= conn.prepareStatement(query);
            
            //fill in the preparedStatement
            
            ps.setInt(1, dogID);
            
            //execute the query
            
            this.results=ps.executeQuery();
            
            this.results.next();
            
            dog.setDogID(this.results.getInt("dogID"));
            dog.setDogName(this.results.getString("dogName"));
            dog.setBreed(this.results.getString("breed"));
            dog.setGender(this.results.getString("gender"));
            dog.setAge(this.results.getInt("age"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
}
    
    public Dogs getDog(){
        
        return this.dog;
        
    }
    
}
