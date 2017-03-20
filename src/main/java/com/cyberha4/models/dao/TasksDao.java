package com.cyberha4.models.dao;

import com.cyberha4.common.exceptions.TaskDaoException;
import com.cyberha4.common.exceptions.TaskNotExistException;
import com.cyberha4.models.db.DbConnection;
import com.cyberha4.models.dao.interfaces.TasksModel;
import com.cyberha4.models.dao.interfaces.UserModel;
import com.cyberha4.models.entity.TaskEntity;
import com.cyberha4.models.entity.UserEntity;
import com.cyberha4.models.pojo.Task;
import com.cyberha4.models.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.sql.Date;
import java.util.*;


/**
 * Created by admin on 25.02.2017.
 */
@Repository
public class TasksDao extends AbstractDao implements TasksModel{
    private UserModel userDAO;

    @Autowired
    public void setUserDAO(UserModel userDAO) {
        this.userDAO = userDAO;
    }

    private static Logger logger = Logger.getLogger(TasksDao.class);

    private static final String SQL_UPDATE_TASKS2 = "UPDATE `tasks` SET `status_id` = ?," +
            " `type_id` = ?, `title` = ?, `annotation` = ?, `text` = ?, `finished_at` = ?" +
            "WHERE `id` = ?";
    private static final String SQL_INSERT_USER2 = "INSERT INTO `Students`.`students` " +
            "(group_id, name, birthday, sex) VALUES (?,?,?,?)";
    public static final int STATUS_DELETE = 5;

    public List<TaskEntity> getAllTasks(int id) {

//        List<Task> tasksList = new ArrayList<>();
//        Task task;
//
//        try (Connection connection = DbConnection.getConnection();
//             ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM tasks WHERE user_id="+id+
//                     " AND status_id != "+STATUS_DELETE)){
//            while(rs.next()){
//                task = new Task();
//                UserDAO userDAO1 = new UserDAO();
//
//                task.setId(rs.getInt("id"));
//                task.setTypeId(rs.getInt("type_id"));
//                task.setStatusId(rs.getInt("status_id"));
//                task.setText(rs.getString("text"));
//                task.setTitle(rs.getString("title"));
//                task.setAnnotation(rs.getString("annotation"));
//                //task.setUser(userDAO1.getUserById(rs.getInt("user_id")));
//                task.setCreatedTime(rs.getInt("created_up"));
//                task.setFinishedTime(rs.getInt("finished_at"));
//                task.setCreate(String.valueOf(rs.getDate("created")));
//                task.setFinished(String.valueOf(rs.getDate("finished")));
//
//                tasksList.add(task);
//            }
//        } catch (SQLException e) {
//            logger.error("something wrong with sql", e);
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("something wrong (not sql)", e);
//        }
//
//        logger.debug("count of finding tasks = " + tasksList.size());
//        return tasksList;

        EntityManager em = getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<TaskEntity> criteriaQuery = criteriaBuilder.createQuery(TaskEntity.class);
        Root<TaskEntity> root = criteriaQuery.from(TaskEntity.class);
        criteriaQuery.select(root);
        UserEntity user = new UserEntity();
        user.setId(id);
        criteriaQuery.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(root.get("user"), user),
                        criteriaBuilder.notEqual(root.get("statusId"), TasksDao.STATUS_DELETE)
                )
        );

        return em.createQuery(criteriaQuery).getResultList();

    }

    public TaskEntity getTaskById(Integer id) throws TaskNotExistException, TaskDaoException {

        EntityManager em = getEntityManager();
        try {
            TaskEntity taskEntity = em.find(TaskEntity.class, id);
            if(taskEntity != null)
                return taskEntity;
            throw new TaskNotExistException();
        } catch (Exception e){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            e.printStackTrace();
            logger.error("Some problem with getTaskById ", e);
            throw new TaskDaoException();
        }
//        Task task = new Task();
//
//        try (Connection connection = DbConnection.getConnection();
//             ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM tasks WHERE id="+id)){
//            while(rs.next()){
//                UserDAO userDAO1 = new UserDAO();
//                task.setId(rs.getInt("id"));
//                task.setTypeId(rs.getInt("type_id"));
//                task.setStatusId(rs.getInt("status_id"));
//                task.setText(rs.getString("text"));
//                task.setTitle(rs.getString("title"));
//                task.setAnnotation(rs.getString("annotation"));
//                task.setUser(userDAO1.getUserById(rs.getInt("user_id")));
//                task.setCreatedTime(rs.getInt("created_up"));
//                task.setFinishedTime(rs.getInt("finished_at"));
//                task.setFinished(rs.getDate("finished").toString());
//                task.setCreate(rs.getDate("created").toString());
//            }
//        } catch (SQLException e) {
//            logger.error("something wrong with sql", e);
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("something wrong (not sql)", e);
//        }
//
//        logger.debug("getTask by id  Title | " + task.getTitle());
//        return task;

//        EntityManager em = getEntityManager();
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        CriteriaQuery<TaskEntity> criteriaQuery = criteriaBuilder.createQuery(TaskEntity.class);
//        Root<TaskEntity> root = criteriaQuery.from(TaskEntity.class);
//        criteriaQuery.select(root);
//        criteriaQuery.where(
//                criteriaBuilder.and(
//                        criteriaBuilder.equal(root.get("login"), "login")
//                )
//        );

//        User user = em.createQuery(criteriaQuery).getSingleResult();

    }

    public boolean isUsersTask(Integer userId, Integer taskId) {
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

    public int insertTask(TaskEntity taskEntity) {
//        int count = 0;
//        String sql = "INSERT INTO `tasks` " +
//                "(status_id, type_id, title, annotation, text, finished_at, user_id, created, finished) VALUES (?,?,?,?,?,?,?,?,?)";
//        try(Connection connection = DbConnection.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setInt(1, task.getStatusId());
//            preparedStatement.setInt(2, task.getTypeId());
//            preparedStatement.setString(3, task.getTitle());
//            preparedStatement.setString(4, task.getAnnotation());
//            preparedStatement.setString(5, task.getText());
//            preparedStatement.setInt(6, task.getFinishedTime());
//            System.out.println("user id "+task.getUser().getId());
//            preparedStatement.setInt(7, task.getUser().getId());
//            preparedStatement.setDate(8, new Date(System.currentTimeMillis()));
//            preparedStatement.setDate(9, Date.valueOf(task.getFinished()));
//
//
//            count = preparedStatement.executeUpdate();
//            logger.debug(" task was insert "+task.getTitle());
//        } catch (SQLException e) {
//            logger.error("sql exception ",e);
//        }
//        return count;
        return saveOrUpdate(taskEntity);

    }

    public int updateTaskOnId(TaskEntity taskEntity) {
//        int count = 0;
//        String sql = "UPDATE `tasks` SET " +
//                "status_id =?, type_id=?, title=?, annotation=?, text=?, finished_at=?, finished=? WHERE id = ?";
//        try(Connection connection = DbConnection.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(sql))
//        {
//            preparedStatement.setInt(1, task.getStatusId());
//            preparedStatement.setInt(2, task.getTypeId());
//            preparedStatement.setString(3, task.getTitle());
//            preparedStatement.setString(4, task.getAnnotation());
//            preparedStatement.setString(5, task.getText());
//            preparedStatement.setInt(6, task.getFinishedTime());
//            preparedStatement.setDate(7, Date.valueOf(task.getFinished()));
//            preparedStatement.setInt(8, task.getId());
//
//            count = preparedStatement.executeUpdate();
//            logger.debug(" task was insert "+task.getTitle());
//        } catch (SQLException e) {
//            logger.error("sql exception ",e);
//        }
//        return count;
        return saveOrUpdate(taskEntity);
    }

    public int deleteTask(int id) {
        int count = 0;
        String sql = "UPDATE `tasks` SET " +
                "status_id =? WHERE id = ?";
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setInt(1, TasksDao.STATUS_DELETE);

            preparedStatement.setInt(2, id);

            count = preparedStatement.executeUpdate();
            logger.debug(" task was delete id = "+id);
        } catch (SQLException e) {
            logger.error("sql exception ",e);
        }
        return count;

    }

    public static TaskEntity findById(int id){
        EntityManager em = getEntityManager();
        try {
            return em.find(TaskEntity.class, id);
        } catch (Exception e){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            e.printStackTrace();
        }
        return null;
    }

}
