/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logging;

/**
 *
 * @author johnk
 */
public interface Logger {
    
    public abstract void logInfo(String info);
    
    public abstract void logWarning(String warning);
    
    public abstract void logError(String error);
    
    
}