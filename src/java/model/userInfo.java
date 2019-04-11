

package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userInfo {
    
    public String username;
    public String password;
    public String level;
    public Integer score;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    
   

   
     public static userInfo populateData(HttpServletRequest request, HttpServletResponse response)
    {
           userInfo ui=new userInfo();
           ui.setUsername(request.getParameter("uname"));
           ui.setPassword(request.getParameter("pass"));
           System.out.println("in userInfo");
           System.out.println("pass"+request.getParameter("pass"));
           
           return ui;
           
    }
}
