
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        
    </head>
    <body>
   
    <div class="container">
        <nav>
   
    <form action="verify" method="post">
    <h3 align="center">Login</h3>
    <div style="color:red">${errorMessage}</div>
    <div>
    <input type="text" placeholder="Username" name="uname" required>  
    <input type="password" placeholder="Password" name="pass" required>
    <button id="login" type="submit">Login</button>
    <br><br>
    <a href="signup.jsp">Register Here</a>
    </nav>
    </div>
  
</form>
            
            
        </div>
    </body>
</html>
