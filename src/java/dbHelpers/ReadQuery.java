
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

public class ReadQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery () {
        
       Properties propa= new Properties();
       InputStream instr=getClass().getResourceAsStream("dbConn.properties");
        try {
            propa.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String driver= propa.getProperty("driver.name");
       String url= propa.getProperty("server.name");
       String username= propa.getProperty("user.name");
       String passwd= propa.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doRead(){
        
        try {
            String query= "Select * FROM dogs ORDER BY dogID ASC";
            
            PreparedStatement ps= conn.prepareStatement(query);
            this.results=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table +="</table>";
            return table;
        
    }
    
}
