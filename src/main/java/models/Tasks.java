package models;

import DataManager.DataManager;
import DataObjects.Task;
import DataObjects.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 19.02.2017.
 */
@XmlRootElement(name = "tasks")
//@XmlType(propOrder = {"users"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Tasks extends Model {
    public static ConcurrentHashMap<String, HashSet<Integer>> hashMap = new ConcurrentHashMap<String, HashSet<Integer>>();

    public Tasks(){

    }

    private void printHashMap(){
        System.out.println("-------------Print Hash Map--------------");

        for (String key : Tasks.hashMap.keySet()) {
            System.out.println("Key : "+key);
            HashSet<Integer> values = Tasks.hashMap.get(key);
            for (Integer value :
                    values){
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("------------------------------------");

    }

    //@XmlElementWrapper(name = "members")
    @XmlElement(name = "task")
    private List<Task> tasks = new ArrayList<Task>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> users) {
        this.tasks = users;
    }

    public Tasks setAllForSer() throws SQLException {

        System.out.println("!!!!!!!!!!!!!!!!!!");
        String sql = "SELECT * FROM tasks LEFT JOIN users ON tasks.user_id=users.id";
        ResultSet rs = getResultSet(sql);
        while(rs.next()){
            System.out.println(rs.getInt("users.id"));
            tasks.add(new Task(
                    rs.getInt("tasks.id"),
                    new User(rs.getInt("users.id"), rs.getString("name")),
                    rs.getInt("status_id"),
                    rs.getInt("type_id"),
                    rs.getString("title"),
                    rs.getString("annotation"),
                    rs.getString("text"))
            );
        }
        return this;
    }

    public void fromXmlToDb() throws SQLException {
        for (Task task :
                tasks) {

            User user = task.getUser();

            String classname = user.getClass().getName();
            while (!DataManager.isContainsRecordsId(classname, user.getId())){
                Thread.yield();
            }


            String sql = "INSERT INTO tasks (id, user_id, title) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, task.getId());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.setString(3, task.getTitle());
            preparedStatement.executeUpdate();
        }
    }
}
