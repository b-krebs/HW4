

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Dog</title>
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
        
        
        
        <h1>Add A New Dog</h1>
        <form name="addForm" action="addDog" method="get">
            <table class="add">
                <tbody>
                    
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" value="" size="50"></td>
                    </tr>
                    
                    <tr>
                        <td>Breed:</td>
                        <td><input type="text" name="breed" value="" size="50"></td>
                    </tr>
                    
                    <tr>
                        <td>Gender</td>
                        <td><input type="text" name="gender" value="" size="50"></td>
                    </tr>
                    
                    <tr>
                        <td>Age:</td>
                        <td><input type="text" name="age" value="" size="50"></td>
                    </tr>
                    
                </tbody>
            </table>
            
            <br><br>
            
            <input type="reset" value="Clear" id="clear">
                    <input type="submit" value="Add" id="add">
            
            
        </form>
        
     
         </div><!--end main--> 
        
        <!--Footer-->
        
        <%@ include file="includes/footer.jsp" %>
      
 </div><!-- end wrap-->
       
    </body>
</html>
