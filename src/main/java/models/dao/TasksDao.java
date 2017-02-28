package models.dao;

import common.exceptions.UserDAOException;
import db.DbConnection;
import models.Model;
import models.pojo.Task;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 25.02.2017.
 */
public class TasksDao {
    private static Logger logger = Logger.getLogger(TasksDao.class);

    private static final String SQL_UPDATE_TASKS2 = "UPDATE `tasks` SET `status_id` = ?," +
            " `type_id` = ?, `title` = ?, `annotation` = ?, `text` = ?, `finished_at` = ?" +
            "WHERE `id` = ?";
    private static final String SQL_INSERT_USER2 = "INSERT INTO `Students`.`students` " +
            "(group_id, name, birthday, sex) VALUES (?,?,?,?)";

    public static List<Task> getAllTasks(int id) {

        List<Task> tasksList = new ArrayList<>();
        Task task;

        try (Connection connection = DbConnection.getConnection();
             ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM tasks WHERE user_id="+id)){
            while(rs.next()){
                task = new Task();
                task.setId(rs.getInt("id"));
                task.setTypeId(rs.getInt("type_id"));
                task.setStatusId(rs.getInt("status_id"));
                task.setText(rs.getString("text"));
                task.setTitle(rs.getString("title"));
                task.setAnnotation(rs.getString("annotation"));
                task.setUser(UserDAO.getUserById(rs.getInt("user_id")));
                //task.setCreatedTime(rs.getInt("created_up"));
                //task.setFinishedTime(rs.getInt("finished_at"));

                tasksList.add(task);
            }
        } catch (SQLException e) {
            logger.error("something wrong with sql", e);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("something wrong (not sql)", e);
        }

        logger.debug("count of finding tasks = " + tasksList.size());
        return tasksList;

    }

    public static Task getTaskById(Integer id) {
        Task task = new Task();

        try (Connection connection = DbConnection.getConnection();
             ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM tasks WHERE id="+id)){
            while(rs.next()){
                task.setId(rs.getInt("id"));
                task.setTypeId(rs.getInt("type_id"));
                task.setStatusId(rs.getInt("status_id"));
                task.setText(rs.getString("text"));
                task.setTitle(rs.getString("title"));
                task.setAnnotation(rs.getString("annotation"));
                task.setUser(UserDAO.getUserById(rs.getInt("user_id")));
                task.setCreatedTime(rs.getInt("created_up"));
                task.setFinishedTime(rs.getInt("finished_at"));
            }
        } catch (SQLException e) {
            logger.error("something wrong with sql", e);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("something wrong (not sql)", e);
        }

        logger.debug("getTask by id  Title" + task.getTitle());
        return task;
    }

    public static boolean isUsersTask(Integer userId, Integer taskId) {
        try (Connection connection = DbConnection.getConnection();
             ResultSet rs = connection.createStatement().executeQuery("SELECT user_id FROM tasks WHERE id="+taskId)){
            rs.next();
            logger.debug("isUserTask user_id = " + rs.getInt(1));
            return rs.getInt(1) == userId;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.debug("Sql Exception", e);
        }

        return false;
    }

    public static int insertTask(Task task) {
        int count = 0;
        String sql = "INSERT INTO `tasks` " +
                "(status_id, type_id, title, annotation, text, finished_at, user_id) VALUES (?,?,?,?,?,?,?)";
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, task.getStatusId());
            preparedStatement.setInt(2, task.getTypeId());
            preparedStatement.setString(3, task.getTitle());
            preparedStatement.setString(4, task.getAnnotation());
            preparedStatement.setString(5, task.getText());
            preparedStatement.setInt(6, task.getFinishedTime());
            System.out.println("user id "+task.getUser().getId());
            preparedStatement.setInt(7, 2);

            count = preparedStatement.executeUpdate();
            logger.debug(" task was insert "+task.getTitle());
        } catch (SQLException e) {
            logger.error("sql exception ",e);
        }
        return count;

    }
}
