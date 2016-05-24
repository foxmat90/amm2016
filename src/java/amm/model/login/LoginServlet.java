/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.login;

import amm.model.factory.AccountFactory;
import amm.model.factory.ClientFactory;
import amm.model.factory.SellerFactory;
import amm.model.factory.ServiceSaleFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author foxma
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login.jsp"}, loadOnStartup = 0)

public class LoginServlet extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";

    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";

    @Override

    public void init() {

        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;

        try {
// si carica a run-time la classe del Driver
// tramite il nome del driver stesso
// N.B. la string dipende dal DBMS in uso
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
// viene sollevata questa eccezione nel caso
// non si riesca a caricare la classe specificata.
// Il DB in questo caso non sarà utilizzabile,
// potrebbe essere il caso di terminare l’applicazione
            Logger.getLogger(LoginServlet.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        AccountFactory.getInstance().setConnectionString(dbConnection);
        ClientFactory.getInstance().setConnectionString(dbConnection);
        SellerFactory.getInstance().setConnectionString(dbConnection);
        ServiceSaleFactory.getInstance().setConnectionString(dbConnection);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //getServletContext().getRequestDispatcher("login.jsp");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        String username = request.getParameter("user");
        String password = request.getParameter("pwd");
        if (username != null && password != null
                && this.login(username, password)) 
        {
            
            session.setAttribute("loggedIn", true);
            session.setAttribute("name", username);
            
            if (userType(username) == 0)
                    {

            
            response.sendRedirect("ClienteServlet");
                    }
            else
            {
                response.sendRedirect("VenditoreServlet");
            }
                
        } 
        else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);

        }
    }

    private boolean login(String username, String password) {
        return ( (username.equals("user") && password.equals("pass")) || (username.equals("vendo") && password.equals("pass")) );
    }
    
        private int userType(String username) {
            if (username.equals("user"))
                return 0;
               else
                if (username.equals("vendo"))
                    return 1;
            return 2;
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
