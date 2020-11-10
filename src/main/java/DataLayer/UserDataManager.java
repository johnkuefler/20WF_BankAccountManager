/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import BusinessLayer.User;
import Logging.ConsoleLogger;
import Logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author johnk
 */
public class UserDataManager extends DataManager {
    
    private Logger logger;
    
    public UserDataManager(Logger logger) {
        super();
        this.logger = logger;
    }
    
    public ArrayList<User> getAll() throws SQLException {
        PreparedStatement sqlStatement = super.getConnection()
                .prepareStatement("  SELECT userId, firstName, lastName, emailAddress, [password] FROM BANK_User");
        
        logger.logInfo(sqlStatement.toString());
        
        ArrayList<User> output = new ArrayList<User>();
        
        ResultSet resultSet = sqlStatement.executeQuery();
        
        while (resultSet.next()) {
            User user = new User(resultSet.getInt(1), resultSet.getString(2), 
                    resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
        
            output.add(user);
        }
        
        return output;
    }
    
    public User getById(int id) throws SQLException 
    {
        PreparedStatement sqlStatement = super.getConnection()
                .prepareStatement("SELECT userId, firstName, lastName, emailAddress, [password] FROM BANK_User WHERE userId = ?");
        sqlStatement.setInt(1, id);
              
        logger.logInfo(sqlStatement.toString());

        ResultSet resultSet = sqlStatement.executeQuery();
        
        while (resultSet.next()) {
            User user = new User(resultSet.getInt(1), resultSet.getString(2), 
                    resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
        
            return user;
        }
        
        return null;
    }
    
    public User create(User newUser) throws SQLException {
        PreparedStatement sqlStatement = super.getConnection()
                .prepareStatement("INSERT INTO BANK_User (firstName, lastName, emailAddress, password) VALUES (?,?,?,?)");
        sqlStatement.setString(1, newUser.getFirstName());
        sqlStatement.setString(2, newUser.getLastName());
        sqlStatement.setString(3, newUser.getEmailAddress());
        sqlStatement.setString(4, newUser.getPassword());

        logger.logInfo(sqlStatement.toString());

        sqlStatement.executeUpdate();
        
        return newUser;
    }
}
