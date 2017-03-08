package com.cyberha4.models;

import com.cyberha4.DataObjects.Status;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 20.02.2017.
 */
@XmlRootElement(name = "statuses")
@XmlAccessorType(XmlAccessType.FIELD)
public class Statuses extends Model {
    @XmlElement(name = "status")
    private List<Status> statuses = new ArrayList<Status>();

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public void setAllForSer() throws SQLException {
        String sql = "SELECT * FROM statuses";
        ResultSet rs = getResultSet(sql);
        while(rs.next()){
            statuses.add(new Status(rs.getInt("id"), rs.getString("status")));
        }
    }

    public void fromXmlToDb() throws SQLException {
        for(Status status:
                statuses) {
            String sql = "INSERT INTO statuses (id, status) VALUES (?, ?)";

            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, status.getId());
            preparedStatement.setString(2, status.getStatus());
            preparedStatement.executeUpdate();
        }
    }
}
