package com.cyberha4;

import com.cyberha4.common.oldclasses.DataManager.DataManager;
import com.cyberha4.common.oldclasses.ReadThread;
import com.cyberha4.common.oldclasses.WriteThread;
import com.cyberha4.models.oldclasses.Model;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.lang.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 19.02.2017.
 */
public class Application {
    private static final Logger logger = Logger.getLogger(Application.class);
    static {
        DOMConfigurator.configure("log4j.xml");
    }
    public static void main(String[] args) {

        Application app = new Application();

        //app.loadFromDbToXml();
//
        //com.cyberha4.ClearDb.clearAllTables();
        app.loadFromXmlToDb();
//
       try {
           Thread.sleep(1500);
           DataManager.printHashMap();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }

    public void loadFromDbToXml() {
        ResultSet rs = null;
        try {
            rs = Model.getResultSet("SHOW TABLES");
            String tableName;
            while (rs.next()){
                tableName = rs.getString(1).substring(0, 1).toUpperCase() + rs.getString(1).substring(1);
                System.out.println(tableName);
                (new java.lang.Thread(new ReadThread(tableName))).start();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadFromXmlToDb(){
        File folder = new File("Xml");
        String className;
        File[] folderEntries = folder.listFiles();
        Thread wThread;
        if (folderEntries != null) {
            for (File entry : folderEntries)
            {
                System.out.println(entry.getName());
                //Здесь запускаем потоки
                if (!entry.isDirectory())
                {
                    className = entry.getName().substring(0, entry.getName().length()-4);

                    System.out.println(className);
    //
                    wThread = new Thread(new WriteThread(className));
                    //wThread.setName(className);
                    wThread.start();
                }
            }
        } else {
            logger.error("XML files not found");
        }
    }
}
