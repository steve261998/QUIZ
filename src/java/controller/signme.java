package controller;




import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.userDAO;
import model.userInfo;


public class signme extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             System.out.println("sign.java");
            HttpSession session=request.getSession();
            userInfo user;
            System.out.println("before populate data");
            user=userInfo.populateData(request,response);
            userDAO u=new userDAO();
            System.out.println("before add user"+user.getUsername());
            u.createAccount(user);
            /*if(signed)
            {*/
               String msg= "Thank You for joining with us"
                                        + "\n\n Have a great learning experince"
                                        + "\n\n Keep sending your feedback to us";
            //System.out.println("signed"+signed);
            //System.out.println("hello your password is:"+request.getParameter("npsw"));
            request.setAttribute("user",user.getUsername());
            session.setAttribute("pass",user.getPassword());
            
            System.out.println("befor the request dispacther");
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    


}
