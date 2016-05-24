/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.factory;

import amm.model.objects.Account;
import amm.model.objects.Client;
import amm.model.objects.Seller;
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
public class ClientFactory {
    
    String connectionString;
    
    
        ClientFactory()
    {
        
    }
        
            public static ClientFactory getInstance()
    {
        ClientFactory client = new ClientFactory();
        return client;
    }
    
    public List<Client> FactoryMethod()
   {
       
    List<Client> clients = new ArrayList<>();
    Client client1 = new Client();
    Client client2 = new Client();
    Client client3 = new Client();
    client1.setNameClient("Edoardo");
    client1.setUsernameClient("Edo88");
    clients.add(client1);
    client2.setNameClient("Giacomo");
    client2.setUsernameClient("Cintu");
    clients.add(client2);
    client3.setNameClient("Nicola");
    client3.setUsernameClient("Turu");
    clients.add(client3);
    return clients;
   }
    
    
        public List<Client> getClient() {

        List<Client> clients = new ArrayList<>();
        ResultSet set = null;
        try {
// stringa di connessione formato
            String db = "jdbc:derby:/Users/davide/develop/db/ammdb";
// creazione e apertura della connessione
// si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ammdb", "useruser", "pass");
// utilizzo della connessione per inviare una query (select)
            Statement stmt = conn.createStatement();
            String sql = "select  * from client";
            set = stmt.executeQuery(sql);
             
            while (set.next()) {
                System.out.println("while set.next");
                
                    Client temp = new Client();
                    temp.setNameClient(set.getString("nome"));
                    temp.setAddressClient(set.getString("address"));
                    temp.setMailClient((set.getString("mail")));
                    temp.setTelClient((set.getString("tel")));
                    temp.setUsernameClient((set.getString("username")));
                    temp.setPasswordClient((set.getString("password")));
                    temp.setAccountClient((set.getInt("account")));
                  
                    
                    clients.add(temp);
                

            }
            stmt.close();
// chiusura della connessione
            conn.close();
        } catch (SQLException ex) {
// nel caso la query fallisca (p.e.  errori di sintassi)
// viene sollevata una SQLException
            Logger.getLogger(Client.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return clients;

    }
    
        public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    } 
    
}
