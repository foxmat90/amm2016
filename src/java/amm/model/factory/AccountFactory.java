/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.factory;

import amm.model.objects.Account;
import amm.model.objects.Client;
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
public class AccountFactory {
    
    String connectionString;
    
    AccountFactory()
    {
        
    }
    
    public static AccountFactory getInstance()
    {
        AccountFactory account = new AccountFactory();
        return account;
    }
    
    
     public List<Account> getAccount() {

        List<Account> clients = new ArrayList<>();
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
                
                    Account temp = new Account();
                    temp.setBalanceAccount(set.getInt("balance"));

                    clients.add(temp);
                

            }
            stmt.close();
// chiusura della connessione
            conn.close();
        } catch (SQLException ex) {
// nel caso la query fallisca (p.e.  errori di sintassi)
// viene sollevata una SQLException
            Logger.getLogger(Account.class.getName()).
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
