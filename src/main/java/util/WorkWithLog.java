package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import java.util.logging.Level;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithLog {
    public static void saveLogFile(WebDriver driver, String name) {
        /// System.out.println(driver.manage().logs().toString());
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        writeToFile(logEntries, name,Level.SEVERE);
        for (LogEntry log : logEntries) {
            System.out.println(log.toString());
        }
    }

    private static void writeToFile(LogEntries logEntries, String name,Level level) {
        File driverLog = new File(name + ".log");
        FileWriter out = null;
        try {
            out = new FileWriter(driverLog);
            for (LogEntry logEntry : logEntries.getAll()) {
                if ((logEntry.getLevel().getName().equals(level.getName().toUpperCase()))||(level.getName().equals("ALL"))) {
                    out.write(logEntry.toString() + "\n");
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
