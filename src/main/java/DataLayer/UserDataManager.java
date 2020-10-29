/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import BusinessLayer.User;
import java.util.ArrayList;

/**
 *
 * @author johnk
 */
public class UserDataManager {
    
    private ArrayList<User> users;
    
    public UserDataManager() {
        users = new ArrayList<User>();
    }
    
    public ArrayList<User> getAll() {
        return users;
    }
    
    public User getById(int id) 
    {
        for (User user : users) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        
        return null;
    }
    
    public User create(User newUser) {
        // later will be: INSERT newUser INTO USERS table
        users.add(newUser);
        
        return newUser;
    }
}
