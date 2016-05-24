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
public class Seller 
{

    String username;
    String password;
    String name;
    String address;
    String mail;
    String tel;
    int account;
    
    
    public Seller() {
        this.username = "";
        this.password = "";
        this.name = "";
        this.address = "";
        this.mail = "";
        this.tel = "";
        this.account=0;
    }
    
    
    
      public String getUsernameSeller() {
        return this.username;
    }

    public void setUsernameSeller(String newUsername) {
        this.username = newUsername;
    }
    
      public String getPasswordSeller() {
        return this.password;
    }

    public void setPasswordSeller(String newPassword) {
        this.password = newPassword;
    }
    
    
     public String getNameSeller() {
        return this.name;
    }

    public void setNameSeller(String newName) {
        this.name = newName;
    }
    
      public String getAddressSeller() {
        return this.address;
    }

    public void setAddressSeller(String newAddress) {
        this.address = newAddress;
    }
    
      public String getMailSeller() {
        return this.mail;
    }

    public void setMailSeller(String newMail) {
        this.mail = newMail;
    }
    
      public String getTelSeller() {
        return this.tel;
    }

    public void setTelSeller(String newTel) {
        this.tel = newTel;
    }
    
        public int getAccountSeller() {
        return this.account;
    }

    public void setAccountSeller(int newAccount) {
        this.account = newAccount;
    }
    
}
