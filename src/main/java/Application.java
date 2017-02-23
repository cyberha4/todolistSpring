import DataManager.DataManager;
import DataObjects.Type;
import DataObjects.User;
import db.ConnectionToDB;
import models.Tasks;
import Jaxb.JaxbParser;
import models.Model;
import DataObjects.Task;
import models.Types;
import models.Users;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.lang.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 19.02.2017.
 */
public class Application {

    public static void main(String[] args) throws SQLException, JAXBException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, InterruptedException {

        System.out.println(Model.getStatement().execute("ALTER TABLE `tasks` ADD CONSTRAINT `tasksusers` "+"" +
                "FOREIGN KEY (`user_id`) REFERENCES `todoList`.`users`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;\n"));

        //loadFromDbToXml();

        loadFromXmlToDb();

       Thread.sleep(3000);
       DataManager.printHashMap();
    }

    static private void loadFromDbToXml() throws SQLException {
        ResultSet rs = Model.getResultSet("SHOW TABLES");
        String tableName;
        while (rs.next()){
            tableName = rs.getString(1).substring(0, 1).toUpperCase() + rs.getString(1).substring(1);
            System.out.println(tableName);
            (new java.lang.Thread(new ReadThread(tableName))).start();
        }
    }

    private static void loadFromXmlToDb(){
        File folder = new File("Xml");
        String className;
        File[] folderEntries = folder.listFiles();
        Thread wThread;
        for (File entry : folderEntries)
        {
            //Здесь запускаем потоки
            if (!entry.isDirectory())
            {
                className = entry.getName().substring(0, entry.getName().length()-4);
//
                wThread = new java.lang.Thread(new WriteThread(className));
                wThread.setName(className);
                wThread.start();
            }
        }
    }
}
