import models.Model;
import org.junit.Test;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by admin on 23.02.2017.
 */
public class ApplicationTest {
    @Test
    public void main() throws Exception {
        //createFolderForXml();

        Application app = new Application();
        /*
        //Запоминаем кол-во пользователей и задач
        int countUsers = getCountRecords("users");
        int countTasks = getCountRecords("tasks");

        //Запоминаем последние и первые значения некоторых полей в таблицах
        ResultSet rs = Model.getResultSet("SELECT * FROM users");
        rs.next();
        String firstUserName = rs.getString("name");
        rs.last();
        String lastUserName = rs.getString("name");
        */
        //rs = Model.getResultSet("SELECT * FROM tasks");
        //rs.next();
        //String firstTaskTitle = rs.getString("title");
        //rs.last();
        //String lastTaskTitle = rs.getString("title");

        // Сохраняем базу в XML
       app.loadFromDbToXml();
       ClearDb.clearAllTables();
//        assertEquals(0,getCountRecords("users"));
//        assertEquals(0,getCountRecords("tasks"));
        //File folder = new File("Xml");
        //System.out.println(folder.getAbsolutePath());

        // Загружаем базу обратно
        app.loadFromXmlToDb();



        //assertEquals(countUsers,getCountRecords("users"));
        //assertEquals(countTasks,getCountRecords("tasks"));
//
        //rs = Model.getResultSet("SELECT * FROM users");
        //rs.next();
        //assertEquals(firstUserName, rs.getString("name"));
        //rs.last();
        //assertEquals(lastUserName, rs.getString("name"));
//
        //rs = Model.getResultSet("SELECT * FROM tasks");
        //rs.next();
        //assertEquals(firstTaskTitle, rs.getString("title"));
        //rs.last();
        //assertEquals(lastTaskTitle, rs.getString("title"));

    }

    @Test
    public void Test(){
        assertTrue(true);
    }

    private void createFolderForXml(){
        File folder = new File("src"+File.separator+"main"+
                        File.separator+"resources"+File.separator+
                        "XML-tests");
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    private int getCountRecords(String tableName) throws SQLException {
        String sql = String.format("SELECT COUNT(*) AS count FROM `%s`", tableName); //  "Hello World!";
        ResultSet rs = Model.getResultSet(sql);
        rs.next();
        return rs.getInt("count");

    }

}