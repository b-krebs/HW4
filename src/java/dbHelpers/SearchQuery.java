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
public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
       
         Properties propa= new Properties();
       InputStream instr=getClass().getResourceAsStream("dbConn.properties");
        try {
            propa.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String driver= propa.getProperty("driver.name");
       String url= propa.getProperty("server.name");
       String username= propa.getProperty("user.name");
       String passwd= propa.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void doSearch (String dogName){
        
        try {
            String query="SELECT * FROM dogs WHERE UPPER(dogName) LIKE ? ORDER BY dogID ASC";
            
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1, "%" + dogName.toUpperCase() + "%");
            this.results= ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        

}
    
    public String getHTMLtable(){
        
            String table="";
            table += "<table class=read>";
            
            table +="<tr id=topRow>";
               
                table+="<th>";
                    table+="ID";
                table+="</th>";
                
                table+="<th>";
                    table+="Name";
                table+="</th>";
                
                table+="<th>";
                    table+="Breed";
                table+="</th>";
                
                table+="<th>";
                    table+="Gender";
                table+="</th>";
                
                table+="<th>";
                    table+="Age";
                table+="</th>";
                
                table+="<th>";
                table+=" ";
                table+="</th>";
                    
               table +="</tr>";
               
               
       
            
        
            
         try {   
             
             if (!this.results.isBeforeFirst()){
                
                table +="<tr>";
                table +="<td colspan='6'>Sorry, this dog does not exist</td>";
                table +="</tr>";
            }
            
            else{
                while(this.results.next()){
                    Dogs dog=new Dogs();
                    dog.setDogID(this.results.getInt("dogID"));
                }
            }
             
            while(this.results.next()){
                
                Dogs dog=new Dogs();
                dog.setDogID(this.results.getInt("dogID"));
                dog.setDogName(this.results.getString("dogName"));
                dog.setBreed(this.results.getString("breed"));
                dog.setGender(this.results.getString("gender"));
                dog.setAge(this.results.getInt("age"));
                
                
               
               
                table += "<tr>";
                
                       
                    table += "<td>";
                        table += dog.getDogID();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += dog.getDogName();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += dog.getBreed();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += dog.getGender();  
                    table +="</td>";
                    
                    table += "<td>";
                        table += dog.getAge();  
                    table +="</td>";
                    
                    table+="<td>";
                        table +="<a href=update?dogID="+ dog.getDogID()+"> Update</a>" 
                                + "<a href=delete?dogID=" + dog.getDogID() + "> Delete </a>";
                        
                    table +="</td>";           
                
                table +="</tr>";
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table +="</table>";
            return table;
        
    }
    
}

