
import BusinessLayer.BankAccount;
import BusinessLayer.BankAccountType;
import BusinessLayer.Transaction;
import BusinessLayer.User;
import DataLayer.BankAccountDataManager;
import DataLayer.TransactionDataManager;
import DataLayer.UserDataManager;
import Logging.ConsoleLogger;
import Logging.Logger;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author johnk
 */
public class Main {

    public static void main(String[] args) {

        Logger logger = new ConsoleLogger();

        BankAccountDataManager bankAccountDm = new BankAccountDataManager();
        UserDataManager userDm = new UserDataManager();
        TransactionDataManager transactionDm = new TransactionDataManager();

        User user1 = new User(1, "John", "Kuefler", "john@test.com", "password123");
        BankAccount account1 = new BankAccount(1, "John Checking", 100, BankAccountType.Checking, 1);
        BankAccount account2 = new BankAccount(2, "John Savings", 500, BankAccountType.Savings, 1);
        Transaction trans1 = new Transaction(1, new Date(), 20, "Dinner", 1);

        User user2 = new User(2, "Bob", "Smith", "bob@test.com", "password123");
        BankAccount account3 = new BankAccount(3, "Bob Money Market", 1000, BankAccountType.MoneyMarket, 2);

        logger.logInfo("Creating users");
        userDm.create(user1);
        userDm.create(user2);

        logger.logInfo("Creating accounts");

        bankAccountDm.create(account1);
        bankAccountDm.create(account2);
        bankAccountDm.create(account3);

        logger.logInfo("Creating transactions");
        transactionDm.create(trans1);

        logger.logInfo("Retreiving accounts");
        ArrayList<BankAccount> johnsAccounts = bankAccountDm.getByUserId(1);
        System.out.println(johnsAccounts);

        logger.logInfo("Retriving transactions");
        ArrayList<Transaction> johnsCheckingTransactions = transactionDm.getByBankAccountId(1);
        System.out.println(transactionDm.getByBankAccountId(1));
    }
}
