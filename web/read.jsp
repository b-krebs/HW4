
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Pawz Dogs</title>
    </head>
    
    <% String table= (String) request.getAttribute("table"); %>
    
    
    <body>
        <h1>Lucky Pawz Dogs</h1>
        
        
        <%= table %>
        
        <a href="add.jsp">Add A New Dog</a>
        
        
    </body>
</html>
