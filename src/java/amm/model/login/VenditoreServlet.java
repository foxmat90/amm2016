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
public class VenditoreServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    
    {
        response.setContentType("text/html");
        //processRequest(request, response);

        PrintWriter out = response.getWriter();
        //

        HttpSession session = request.getSession(false);
        
        
        ServiceSaleFactory fac = new ServiceSaleFactory();
        String act = request.getParameter("act");
if (act == null) {
    //no button has been selected
} else if (act.equals("Invia")) {
        String nome_oggetto = request.getParameter("nome_oggetto");
        String url_immagine = request.getParameter("url_immagine");
        String descr= request.getParameter("descr");
        float prezzo= Float.valueOf(request.getParameter("prezzo"));
        int quantita= Integer.parseInt(request.getParameter("quantita'"));
        
        
        fac.addServiceSale(nome_oggetto, descr, "", "", prezzo, "", quantita);
        
} else if (act.equals("Elimina")) {
    String nome_oggetto = request.getParameter("nome_oggetto");
    fac.deleteServiceSale(Integer.parseInt(nome_oggetto));
    //update button was pressed
} else if (act.equals("Modifica")) {
     String nome_oggetto = request.getParameter("nome_oggetto");
    String url_immagine = request.getParameter("url_immagine");
    String descr= request.getParameter("descr");
    fac.alterServiceSale(Integer.parseInt(nome_oggetto), url_immagine, descr);
}
       
        
         if(session.getAttribute("loggedIn")!= null && session.getAttribute("loggedIn").equals(true) && session.getAttribute("name").equals("vendo")) 
        {
            String name = (String) session.getAttribute("name");
            
            request.getRequestDispatcher("venditore.jsp").include(request, response);
            
            
            
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
