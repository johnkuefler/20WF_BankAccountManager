/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import BusinessLayer.BankAccount;
import java.util.ArrayList;

/**
 *
 * @author johnk
 */
public class BankAccountDataManager {
    
    private ArrayList<BankAccount> bankAccounts;
    
    public BankAccountDataManager() {
        this.bankAccounts = new ArrayList<BankAccount>();
    }
    
    public BankAccount create(BankAccount accountToCreate) {
        
        //eventually - INSERT INTO some table with SQL
        this.bankAccounts.add(accountToCreate);
        
        return accountToCreate;
    }
    
    public ArrayList<BankAccount> getByUserId(int userId) {
        ArrayList<BankAccount> output = new ArrayList<BankAccount>();
        
        for (BankAccount account : this.bankAccounts) {
            if (account.getUserId() == userId) {
                output.add(account);
            }
        }
        
        return output;
    }
}
