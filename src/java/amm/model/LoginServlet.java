/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "password";
        
     
//    public void init() throws ServletException 
//    {
//        //we can create DB connection resource here and set it to Servlet context
//        if(getServletContext().getInitParameter("dbURL").equals("jdbc:mysql://localhost/mysql_db") &&
//                getServletContext().getInitParameter("dbUser").equals("mysql_user") &&
//                getServletContext().getInitParameter("dbUserPwd").equals("mysql_pwd"))
//        getServletContext().setAttribute("DB_Success", "True");
//        else throw new ServletException("DB Connection error");
//    }
 
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
 
        //get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
         
        //get servlet config init params
  //      String userID = getServletConfig().getInitParameter("user");
  //      String password = getServletConfig().getInitParameter("password");
        //logging example
       // log("User="+user+"::password="+pwd);
         
        if(userID.equals(user) && password.equals(pwd))
        {
            HttpSession session = request.getSession();
            session.setAttribute("user", "Mattia");
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            response.sendRedirect("/Amm2016/M3/LoginSuccess.jsp");
        }
        else
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/M3/login.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
             
        }
         
    }
 
}