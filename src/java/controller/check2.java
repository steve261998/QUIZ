/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.question;
import model.userDAO;
import model.userInfo;

/**
 *
 * @author ROCHELLE
 */
public class check2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            userInfo u=new userInfo();
            Integer score=0;
           
            String select1=request.getParameter("op1");
            String select2=request.getParameter("op2");
            String select3=request.getParameter("op3");
            String select4=request.getParameter("op4");
            //String select5=request.getParameter("op5");
            String ans1="u";
            String ans2="Header File";
            String ans3="CSS";
            //String ans4="VDU";
            String ans4="";
            int i;
            if(select1.equals(ans1))
            {
                score++;
          
            }
            if(select2.equals(ans2))
            {
                score++;
          
            }
            if(select3.equals(ans3))
            {
                score++;
          
            }
            if(select4.equals(ans4))
            {
                score++;
          
            }
           /* if(select5.equals(ans5))
            {
                score++;
          
            }*/
            //question q=new question();
            
           // String num=q.getNo();
            //System.out.println("check num is paasing"+select);
            //userDAO u=new userDAO();
           // u.check1(select1,select2,select3,select4,select5);
           // System.out.println("after check");
           request.setAttribute("score",score);
             RequestDispatcher rd=request.getRequestDispatcher("score.jsp");
            rd.forward(request, response);
            
        }
    }

    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

}
