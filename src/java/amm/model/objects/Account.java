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
public class Account {

    float balance;

    public Account() {

        this.balance = 0;

    }

    public float getBalanceAccount() {
        return this.balance;
    }

    public void setBalanceAccount(float newBalance) {
        this.balance = newBalance;
    }

    public void AddBalanceAccount(float toAdd) {
        this.balance += toAdd;
    }

    public void SubBalanceAccount(float toSub) {
        this.balance -= toSub;
    }

}
