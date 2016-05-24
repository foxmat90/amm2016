/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.factory;

import amm.model.objects.ServiceSale;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author foxma
 */
public class ServiceSaleFactory {

    String connectionString;

    public ServiceSaleFactory() {

    }

    public static ServiceSaleFactory getInstance() {
        ServiceSaleFactory account = new ServiceSaleFactory();
        return account;
    }

    public List<ServiceSale> FactoryMethod() {

        List<ServiceSale> services = new ArrayList<>();
        ServiceSale service1 = new ServiceSale();
        ServiceSale service2 = new ServiceSale();
        ServiceSale service3 = new ServiceSale();
        service1.setNameService("Prodotto finanziario alto rischio");
        service1.setPicService("desc1");
        service1.setNumbersService(1);
        services.add(service1);
        service2.setNameService("RTY");
        service2.setDescriptionService("desc2");
        services.add(service2);
        service3.setNameService("UIO");
        service3.setDescriptionService("desc3");
        services.add(service3);
        return services;
    }

    public List<ServiceSale> getServiceSale() {

        List<ServiceSale> services = new ArrayList<>();
        ResultSet set = null;
        try {
// stringa di connessione formato
            String db = "jdbc:derby:/Users/davide/develop/db/ammdb";
// creazione e apertura della connessione
// si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ammdb", "useruser", "pass");
// utilizzo della connessione per inviare una query (select)
            Statement stmt = conn.createStatement();
            String sql = "select  * from servicesale";
            set = stmt.executeQuery(sql);
             
            while (set.next()) {
                System.out.println("while set.next");
                
                    ServiceSale temp = new ServiceSale();
                    temp.setNameService(set.getString("nome"));
                    System.out.println(temp.getNameService());
                    temp.setDescriptionService(set.getString("description"));
                    temp.setNumbersService((set.getInt("numbers")));
                    temp.setPriceService((set.getFloat("price")));
                    temp.setLinkService((set.getString("links")));
                    temp.setPicService((set.getString("pic")));
                    System.out.println(temp.getPicService());
                    
                    services.add(temp);
                

            }
            stmt.close();
// chiusura della connessione
            conn.close();
        } catch (SQLException ex) {
// nel caso la query fallisca (p.e.  errori di sintassi)
// viene sollevata una SQLException
            Logger.getLogger(ServiceSale.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return services;

    }
    
    public ServiceSale selectById(int id)
    {
        ServiceSale service = new ServiceSale();
        ResultSet set = null;
        try {
// stringa di connessione formato
            String db = "jdbc:derby:/Users/davide/develop/db/ammdb";
// creazione e apertura della connessione
// si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ammdb", "useruser", "pass");
// utilizzo della connessione per inviare una query (select)
            Statement stmt = conn.createStatement();
            String sql = "select  * from servicesale WHERE servicesale.id = " + id;
            set = stmt.executeQuery(sql);
             
            while (set.next()) {
                System.out.println("while set.next");
                
                    ServiceSale temp = new ServiceSale();
                    temp.setNameService(set.getString("nome"));
                    System.out.println(temp.getNameService());
                    temp.setDescriptionService(set.getString("description"));
                    temp.setNumbersService((set.getInt("numbers")));
                    temp.setPriceService((set.getFloat("price")));
                    temp.setLinkService((set.getString("links")));
                    temp.setPicService((set.getString("pic")));
                    System.out.println(temp.getPicService());
                    
                    service = temp;
                

            }
            stmt.close();
// chiusura della connessione
            conn.close();
        } catch (SQLException ex) {
// nel caso la query fallisca (p.e.  errori di sintassi)
// viene sollevata una SQLException
            Logger.getLogger(ServiceSale.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return service;
    }
    
    
    
    public void addServiceSale(String nome, String description, String risk, String links, float price, String pic, int numbers)
    {
//        ServiceSale serviceSaleToAdd = new ServiceSale();
//        serviceSaleToAdd.setDescriptionService(description);
//        serviceSaleToAdd.setNameService(nome);
//        serviceSaleToAdd.setRiskService(risk);
//        serviceSaleToAdd.setLinkService(links);
//        serviceSaleToAdd.setPriceService(price);
//        serviceSaleToAdd.setPicService(pic);
//        serviceSaleToAdd.setNumbersService(numbers);

        ResultSet set = null;
        try {
// stringa di connessione formato
            String db = "jdbc:derby:/Users/davide/develop/db/ammdb";
// creazione e apertura della connessione
// si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ammdb", "useruser", "pass");
// utilizzo della connessione per inviare una query (select)
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO servicesale (id, nome, description, risk, links, price, pic, numbers)" + "VALUES (default, '" + nome + "', '" + description + "', '" + risk + "', '" + links + "', " + price + ", '" + pic + "', " + numbers + ")";
           stmt.executeUpdate(sql);
          
            stmt.close();
// chiusura della connessione
            conn.close();
        } catch (SQLException ex) {
// nel caso la query fallisca (p.e.  errori di sintassi)
// viene sollevata una SQLException
            Logger.getLogger(ServiceSale.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        //return serviceSaleToAdd;
    }
    
    
    
       public void deleteServiceSale(int id)
    {
//        ServiceSale serviceSaleToAdd = new ServiceSale();
//        serviceSaleToAdd.setDescriptionService(description);
//        serviceSaleToAdd.setNameService(nome);
//        serviceSaleToAdd.setRiskService(risk);
//        serviceSaleToAdd.setLinkService(links);
//        serviceSaleToAdd.setPriceService(price);
//        serviceSaleToAdd.setPicService(pic);
//        serviceSaleToAdd.setNumbersService(numbers);

        ResultSet set = null;
       ServiceSale service = new ServiceSale();
       service = this.selectById(id);
       
        try {
// stringa di connessione formato
            String db = "jdbc:derby:/Users/davide/develop/db/ammdb";
// creazione e apertura della connessione
// si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ammdb", "useruser", "pass");
// utilizzo della connessione per inviare una query (select)
            Statement stmt = conn.createStatement();
            String sql = "DELETE from servicesale WHERE " + " id = " + id;
            //String sql = "UPDATE servicesale SET nome = '" + newValue + "' WHERE " + " id = " + id;

            stmt.executeUpdate(sql);
          
            stmt.close();
// chiusura della connessione
            conn.close();
        } catch (SQLException ex) {
// nel caso la query fallisca (p.e.  errori di sintassi)
// viene sollevata una SQLException
            Logger.getLogger(ServiceSale.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        //return serviceSaleToAdd;
    }

              public void alterServiceSale(int id, String field, String newValue)
    {
//        ServiceSale serviceSaleToAdd = new ServiceSale();
//        serviceSaleToAdd.setDescriptionService(description);
//        serviceSaleToAdd.setNameService(nome);
//        serviceSaleToAdd.setRiskService(risk);
//        serviceSaleToAdd.setLinkService(links);
//        serviceSaleToAdd.setPriceService(price);
//        serviceSaleToAdd.setPicService(pic);
//        serviceSaleToAdd.setNumbersService(numbers);

        ResultSet set = null;
       ServiceSale service = new ServiceSale();
       service = this.selectById(id);
       
        try {
// stringa di connessione formato
            String db = "jdbc:derby:/Users/davide/develop/db/ammdb";
// creazione e apertura della connessione
// si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ammdb", "useruser", "pass");
// utilizzo della connessione per inviare una query (select)
            Statement stmt = conn.createStatement();
            String sql = "UPDATE servicesale SET " + field + " = '" + newValue + "' WHERE " + " id = " + id;
            //String sql = "UPDATE servicesale SET nome = '" + newValue + "' WHERE " + " id = " + id;

            stmt.executeUpdate(sql);
          
            stmt.close();
// chiusura della connessione
            conn.close();
        } catch (SQLException ex) {
// nel caso la query fallisca (p.e.  errori di sintassi)
// viene sollevata una SQLException
            Logger.getLogger(ServiceSale.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        //return serviceSaleToAdd;
    }
       
       
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }
}
