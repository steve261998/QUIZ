///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import model.question;
//import model.userDAO;
//
///**
// *
// * @author ROCHELLE
// */
//public class getq extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            question q=new question();
//            userDAO u=new userDAO();
//           System.out.println("before dao");
//            List<question> questionl;
//           
//                questionl= u.getQuest();
//                request.setAttribute("question",questionl);
//            } 
//            System.out.println("after dao");
//           
//          
////            Integer score=0;
////            HttpSession session=request.getSession();
//////           request.setAttribute("user",u.getUname());
//////           session.setAttribute("ID",q.getId());
//////           session.setAttribute("q",q.getQuestion());
//////           session.setAttribute("email",q.getOp1());
//////           session.setAttribute("gender",q.getOp2());
//////           session.setAttribute("bday",q.getOp3());
//////            
////            
////            String select1=request.getParameter("op1");
////            String select2=request.getParameter("op2");
////            String select3=request.getParameter("op3");
//////            String select4=request.getParameter("op4");
////            
////            String ans=q.getAnswer();
////                       //question q=new question();
////            
////           // String num=q.getNo();
////            //System.out.println("check num is paasing"+select);
////            //userDAO u=new userDAO();
////           // u.check1(select1,select2,select3,select4,select5);
////           // System.out.println("after check");
////           
//           
//           
//             RequestDispatcher rd=request.getRequestDispatcher("qivequiz.jsp");
//            rd.forward(request, response);
//            
//        } 
//        }
//    }
//
