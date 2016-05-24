/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model.objects;

/**
 *
 * @author foxma
 */
public class Client 
{
    String username;
    String password;
    String name;
    String address;
    String mail;
    String tel;
    int account;
            
     public Client() {
        this.username = "";
        this.password = "";
        this.name = "";
        this.address = "";
        this.mail = "";
        this.tel = "";
        this.account = 0;
    }
    
    
    
      public String getUsernameClient() {
        return this.username;
    }

    public void setUsernameClient(String newUsername) {
        this.username = newUsername;
    }
    
      public String getPasswordClient() {
        return this.password;
    }

    public void setPasswordClient(String newPassword) {
        this.password = newPassword;
    }
    
    
     public String getNameClient() {
        return this.name;
    }

    public void setNameClient(String newName) {
        this.name = newName;
    }
    
      public String getAddressClient() {
        return this.address;
    }

    public void setAddressClient(String newAddress) {
        this.address = newAddress;
    }
    
      public String getMailClient() {
        return this.mail;
    }

    public void setMailClient(String newMail) {
        this.mail = newMail;
    }
    
      public String getTelClient() {
        return this.tel;
    }

    public void setTelClient(String newTel) {
        this.tel = newTel;
    }
    
          public int getAccountClient() {
        return this.account;
    }

    public void setAccountClient(int newAccount) {
        this.account = newAccount;
    }
    
 
}
