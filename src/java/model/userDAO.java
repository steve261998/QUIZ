
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class userDAO extends baseDAO {
   Connection conn;
   PreparedStatement st;
   ResultSet rs;
    public String verify(String uname,String pass) throws SQLException, ClassNotFoundException
    {
        String sql="select * from ROSH.usert where uname=? and pass=?";
        String sql1="select * from public.admin where aname=? and apass=?";
        try
        {
            conn=getConnection();
            st=conn.prepareStatement(sql);
            st.setString(1,uname);
            st.setString(2,pass);
            rs=st.executeQuery(); 
            if(rs.next())
            {     
                return "user";
            }
            else
            {
               
                System.out.println("adminname"+uname);
                System.out.println("adminpass"+pass);
                  conn=getConnection();
                  st=conn.prepareStatement(sql1);
                  st.setString(1,uname);
                  st.setString(2,pass);
                  rs=st.executeQuery();
                   if(rs.next())
                 {     
                return "admin";
                  }
            }
        }
        catch (SQLException e) {
             Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return "null";
    }
    public boolean createAccount(userInfo u) throws ClassNotFoundException 
    {
      conn=null;
      st=null;
      System.out.println("username"+u.getUsername());
      String query1="INSERT INTO ROSH.usert(uname, pass)VALUES (?, ?)";
        try {
            conn = getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         try {

           
            st= conn.prepareStatement(query1);
            st.setString(1,u.getUsername());
            st.setString(2,u.getPassword());
            int res=st.executeUpdate();
            if(res>0)
            {
                System.out.println("done");
                return true;
            }
            conn.commit();
           
           
         }
         catch (SQLException ex) {
              Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                    
                }

         return false;
         
        
        
    }
public List getQuest() throws ClassNotFoundException, SQLException
    {    List<question> addlist=new ArrayList<>();
        
        String sql="select * from ROSH.mcq";
        System.out.println("question dao");
        try{
             conn=getConnection();
            st=conn.prepareStatement(sql);
           question u = new question();
          
            rs=st.executeQuery();
            while(rs.next())
            {   
                System.out.println("test");
                u.setId(rs.getString(1));
                u.setQuestion(rs.getString(2));
                u.setOp1(rs.getString(3));
                u.setOp2(rs.getString(4));
                u.setOp3(rs.getString(5));
                u.setAnswer(rs.getString(6));  
                System.out.println(u.getQuestion());
                addlist.add(u);
                
            }
            
        }     
           catch (SQLException ex) {
                Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
        
            
        return addlist;
    }

}