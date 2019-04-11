<%-- 
    Document   : signup
    Created on : 5 Mar, 2019, 9:49:04 PM
    Author     : ROCHELLE
--%>


<html>
    <head>
        <title>Sign Up</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
       <div class="container">
       <form id="signup" action="signme" method="post">
       <div>
           <h2 align="center">Sign Up</h2><br>
       <div style="color:red">${errorMessage}</div>
       
       <div>
  
    <input type="text" placeholder="Enter Username" name="uname" required><br>
    <br>
      
    
    <input type="password" name="pass" placeholder="Enter Password" required>
    
    <br>
    <button id="login" type="submit">Sign me up</button>
    <br><br>
    <button id="login" type="button" class="cancelbtn">Cancel</button>
       </div>
        </div>
    </form>
       
       </div>
            
    </body>
</html>
