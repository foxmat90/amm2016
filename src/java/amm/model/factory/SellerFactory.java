/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.factory;

import amm.model.objects.Seller;
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
public class SellerFactory {
    
    String connectionString;
    
    SellerFactory()
    {
        
    }
    
             public static SellerFactory getInstance()
    {
        SellerFactory seller = new SellerFactory();
        return seller;
    }
    
        public List<Seller> FactoryMethod()
   {
       
    List<Seller> sellers = new ArrayList<>();
    Seller seller1 = new Seller();
    Seller seller2 = new Seller();
    Seller seller3 = new Seller();
    seller1.setNameSeller("Edoardo");
    seller1.setUsernameSeller("Edo88");
    sellers.add(seller1);
    seller2.setNameSeller("Giacomo");
    seller2.setUsernameSeller("Cintu");
    sellers.add(seller2);
    seller3.setNameSeller("Nicola");
    seller3.setUsernameSeller("Turu");
    sellers.add(seller3);
    return sellers;
   }
        
         public List<Seller> getSeller() {

        List<Seller> sellers = new ArrayList<>();
        ResultSet set = null;
        try {
// stringa di connessione formato
            String db = "jdbc:derby:/Users/davide/develop/db/ammdb";
// creazione e apertura della connessione
// si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ammdb", "useruser", "pass");
// utilizzo della connessione per inviare una query (select)
            Statement stmt = conn.createStatement();
            String sql = "select  * from seller";
            set = stmt.executeQuery(sql);
             
            while (set.next()) {
                System.out.println("while set.next");
                
                    Seller temp = new Seller();
                    temp.setNameSeller(set.getString("nome"));
                    temp.setAddressSeller(set.getString("address"));
                    temp.setMailSeller((set.getString("mail")));
                    temp.setTelSeller((set.getString("tel")));
                    temp.setUsernameSeller((set.getString("username")));
                    temp.setPasswordSeller((set.getString("password")));
                    temp.setAccountSeller((set.getInt("account")));
                  
                    
                    sellers.add(temp);
                

            }
            stmt.close();
// chiusura della connessione
            conn.close();
        } catch (SQLException ex) {
// nel caso la query fallisca (p.e.  errori di sintassi)
// viene sollevata una SQLException
            Logger.getLogger(Seller.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return sellers;

    }
        
            public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    } 
}
