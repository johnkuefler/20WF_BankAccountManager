/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import BusinessLayer.Transaction;
import java.util.ArrayList;

/**
 *
 * @author johnk
 */
public class TransactionDataManager {
    private ArrayList<Transaction> transactions;
    
    public TransactionDataManager() {
        this.transactions = new ArrayList<Transaction>();
    }
    
    public Transaction create(Transaction transToCreate) {
        this.transactions.add(transToCreate);
        
        return transToCreate;
    }
    
    public ArrayList<Transaction> getAll() {
        return this.transactions;
    }
    
    public ArrayList<Transaction> getByBankAccountId(int bankAccountNumber) {
        ArrayList<Transaction> output = new ArrayList<Transaction>();
        
        for (Transaction trans : this.transactions) {
            if (trans.getBankAccountNumber() == bankAccountNumber) {
                output.add(trans);
            }
        }
        
        return output;
    }
}
