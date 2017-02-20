import DataObjects.Tasks;
import Jaxb.JaxbParser;
import models.Model;
import models.Task;
import models.User;
import DataObjects.Users;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.lang.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by admin on 19.02.2017.
 */
public class Application {

    public static void main(String[] args) throws SQLException, JAXBException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //System.out.println("init");
        //User user = User.findUserById(1);
        //System.out.println(user.getName());

        Jaxb.Parser parser = new JaxbParser();
        File file = new File("Tasks.xml");
        
        ArrayList<String> tables = new ArrayList<String>();
        ResultSet rs = Model.getResultSet("SHOW TABLES");

        //Запускаем потоки
        String tableName;
        while (rs.next()){
            tableName = rs.getString(1).substring(0, 1).toUpperCase() + rs.getString(1).substring(1);
            System.out.println(tableName);
            tables.add(rs.getString(1));

            if (tableName.equals("Users") || tableName.equals("Tasks")) {
                (new java.lang.Thread(new Thread(tableName))).start();
            }
        }
        Tasks tasks = new Tasks();

        //parser.saveObject(tasks.setAllForSer());
        tasks = (Tasks) parser.getObject(Tasks.class);

        System.out.println(tasks.getTasks().get(0).getTitle());

        Users users = (Users) parser.getObject(Users.class);

        System.out.println(users.getUsers().get(0).getName());


        System.exit(1);

        //Task task = Task.findById(1);
        //System.out.println(task.getText());
        //System.out.println(task.getUser().getName());

        //parser.saveObject(file, task);
//
        //ArrayList<User> list = new ArrayList<User>();
        //list.add(user);
        //list.add(user2);
//
        //parser.saveObject(file, users);
        //user = (User) parser.getObject(file, user.getClass());

        Task task = (Task) parser.getObject(file, Task.class);
        System.out.println(task.getTitle());
        System.out.println(task.getUser().getName());

    }
}
