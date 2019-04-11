package controller;

//
//package controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import model.question;
//import model.userDAO;
//public class dispquiz extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            
//            userDAO u=new userDAO();
//            question q=new question();
//            question ques;
//                ques=u.dispquiz(1);
//                request.setAttribute("no",ques.getNo());
//                request.setAttribute("stmt",ques.getStmt());
//                request.setAttribute("option1",ques.getOption1());
//                request.setAttribute("option2",ques.getOption2());
//                request.setAttribute("option3",ques.getOption3());
//                request.setAttribute("option4",ques.getOption4());
//                System.out.println("hello"+ques.getOption1());
//                RequestDispatcher rd=request.getRequestDispatcher("givequiz.jsp");
//                rd.forward(request, response);
//   
//            
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//   
//    
//}
