

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Dog</title>
    </head>
    <body>
        <h1>Add A New Dog</h1>
        <form name="addDog" action="read.jsp" method="post">
            <table>
                <tbody>
                    
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="dogName" value="" size="50"></td>
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
                        <td><input type="text" name="dogName" value="" size="50"></td>
                    </tr>
                    
                </tbody>
            </table>
            
            <input type="reset" value="Clear" id="clear">
                    <input type="submit" value="Add" id="add">
            
            
        </form>
        
     
       
    </body>
</html>
