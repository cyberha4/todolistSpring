package models;

import DataObjects.Status;
import DataObjects.Type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by admin on 20.02.2017.
 */
@XmlRootElement(name = "types")
@XmlAccessorType(XmlAccessType.FIELD)
public class Types extends Model{
    @XmlElement(name = "type")
    private List<Type> types = new ArrayList<Type>();

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Status> statuses) {
        this.types = types;
    }

    public void setAllForSer() throws SQLException {
        String sql = "SELECT * FROM types";
        ResultSet rs = getResultSet(sql);
        while(rs.next()){
            types.add(new Type(rs.getInt("id"), rs.getString("type")));
        }
    }

    //HashMap<String, HashSet<Integer>> hashMap = new HashMap<>(); // Хранить название полей в ключе хэшмапа и количество индексов в дереве по этому ключу.

    public void fromXmlToDb() throws SQLException {
        for(Type type:
                types) {
            String sql = "INSERT INTO types (id, type) VALUES (?, ?)";

            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, type.getId());
            preparedStatement.setString(2, type.getType());
            preparedStatement.executeUpdate();
        }
    }

}
