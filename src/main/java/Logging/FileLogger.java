/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logging;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 *
 * @author johnk
 */
public class FileLogger implements Logger {
    // static members/functions
    
    private static String logPath;
    private void setLogPath() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        logPath = "C:/users/johnk/desktop/Log-" + timeStamp + ".txt";
    }
    
    public FileLogger() {

        // initialize log file
        setLogPath();
        
        PrintWriter pw;
        try {
            pw = new PrintWriter(logPath);
            pw.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(FileLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void logInfo(String logData) {
        try {
            this.appendToLog(logData, "info");
        } catch (IOException ex) {
            //Logger.getLogger(FileLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void logWarning(String logData) {
        try {
            this.appendToLog(logData, "warning");
        } catch (IOException ex) {
            //Logger.getLogger(FileLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void logError(String logData) {
        try {
            this.appendToLog(logData, "error");
        } catch (IOException ex) {
            //Logger.getLogger(FileLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void appendToLog(String logData, String level) throws IOException {
        FileWriter fw = new FileWriter(logPath, true);
        PrintWriter pw = new PrintWriter(fw);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        pw.println(level + ":\t[" + timeStamp + "] - " + logData);
        pw.close();
    }
}
