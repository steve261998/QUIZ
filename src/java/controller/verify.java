package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.userDAO;
@WebServlet(name = "verify", urlPatterns = {"/verify"})
public class verify extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String uname=request.getParameter("uname");
           String pass=request.getParameter("pass");
           HttpSession session=request.getSession();
           if(uname.equals("admin") && pass.equals("admin"))
              {
                   response.sendRedirect("admin.jsp");
              }
           System.out.println("heyyy"+uname);
           System.out.println("heyyy"+pass);
           userDAO u=new userDAO();
            try {
                if(u.verify(uname,pass).equals("user"))
                {
                    System.out.println("veriy if");
                    
                    
                    request.setAttribute("user",uname);
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
                else
                {
                    System.out.println("veriy else");
                    request.setAttribute("errorMessage", "Invalid user or password");
                    RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }} catch (SQLException ex) {
                Logger.getLogger(verify.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(verify.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        
    }
    }
}



