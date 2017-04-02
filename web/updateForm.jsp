
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Dogs"%>
<% Dogs dog= (Dogs) request.getAttribute("dog"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Dog</title>
        
        <link rel = "stylesheet"
   type = "text/css"
   href = "css/inputStyle.css" />
        
    </head>
    <body>
        
       <div class="wrap">    
     
            <!--Header-->
            
            <%@ include file="includes/header.jsp" %>
            
            <!--Menu-->
            
            <%@ include file="includes/menu.jsp" %>
     
        <div class="main">
       
            
            <h1>Update A Dog</h1>
        
        <form name="updateForm" action="updateDog" method="get">
        <table class="update">
            <tbody>
                
                    <tr>
                        <td>Dog ID:</td>
                        <td><input type="text" name="id" value="<%= dog.getDogID() %>" readonly /></td>
                    </tr>
                
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" value="<%= dog.getDogName() %>" ></td>
                    </tr>
                    
                   
                    <tr>
                        <td>Breed:</td>
                        <td><input type="text" name="breed" value="<%= dog.getBreed() %>" ></td>
                    </tr>
                    
                    <tr>
                        <td>Gender</td>
                        <td><input type="text" name="gender" value="<%= dog.getGender() %>"></td>
                    </tr>
                    
                    <tr>
                        <td>Age:</td>
                        <td><input type="text" name="age" value="<%= dog.getAge() %>"></td>
                    </tr>
                    
                </tbody>
                
               
        </table>
                    <br><br>
                    
                    <input type="reset" value="Clear" id="clear">
                    <input type="submit" value="Update" id="update">
            
        </form>
                    
                    
                    
                    
          </div><!--end main--> 
        
        <!--Footer-->
        
        <%@ include file="includes/footer.jsp" %>
      
 </div><!-- end wrap-->
        
    </body>
</html>
