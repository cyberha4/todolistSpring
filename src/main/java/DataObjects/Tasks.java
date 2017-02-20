package DataObjects;

import models.Model;
import models.Task;
import models.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 19.02.2017.
 */
@XmlRootElement(name = "tasks")
//@XmlType(propOrder = {"users"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Tasks extends Model {
    public Tasks(){

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
}
