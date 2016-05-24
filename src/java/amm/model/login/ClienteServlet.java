/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import amm.model.factory.*;
import amm.model.objects.ServiceSale;
import java.util.List;

/**
 *
 * @author foxma
 */
public class ClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    
    {
        response.setContentType("text/html");
        //processRequest(request, response);

        PrintWriter out = response.getWriter();
        //

        HttpSession session = request.getSession(false);
        
        
        ServiceSaleFactory fac = new ServiceSaleFactory();
        fac.deleteServiceSale(10);
        //fac.addServiceSale("nuova", "desc", " molto alto", "link", 456, "alto.jpg", 55);
        List<ServiceSale> listServices = fac.getServiceSale();
        request.setAttribute("listServices", listServices);
        request.setAttribute("url", listServices.size() );
        
        
         if(session.getAttribute("loggedIn")!= null && session.getAttribute("loggedIn").equals(true) && session.getAttribute("name").equals("user")) 
        {
            String name = (String) session.getAttribute("name");
            
            request.getRequestDispatcher("cliente.jsp").include(request, response);
            
            
            
        } 
        else 
        {
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            out.println("<font color=red>Please login first.</font>");
            rd.include(request, response);
 
            
            //response.sendRedirect("LoginServlet");
        }
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        this.processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        this.processRequest(request, response);

    }
}
