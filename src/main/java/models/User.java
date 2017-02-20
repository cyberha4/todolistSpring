package models;

import javax.xml.bind.annotation.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 19.02.2017.
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends Model {
    //@XmlAttribute(name = "id")
    private int id;
    private String name;

    public User(){

    }


    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User findUserById(int id) throws SQLException {
        ResultSet rs = getResultSet("SELECT * FROM users WHERE id = "+id);
        User user = null;
        while(rs.next()){
            //System.out.println(rs.getString("name"));
            user = new User(rs.getInt("id"), rs.getString("name"));
        }
        return user;

    }
}
