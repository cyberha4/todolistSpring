package DataObjects;

import models.Model;
import models.User;

import javax.xml.bind.annotation.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 19.02.2017.
 */
@XmlRootElement(name = "users")
//@XmlType(propOrder = {"users"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Users extends Model {
    public Users(){

    }

    //@XmlElementWrapper(name = "members")
    @XmlElement(name = "user")
    private List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setAllForSer() throws SQLException {
        System.out.println("!!!!!!!!!!!!!!!!!!");
        String sql = "SELECT * FROM users";
        ResultSet rs = getResultSet(sql);
        while(rs.next()){
            users.add(new User(rs.getInt("id"), rs.getString("name")));
        }
    }
}
