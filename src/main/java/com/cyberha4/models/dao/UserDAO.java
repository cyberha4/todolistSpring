package com.cyberha4.models.dao;

import com.cyberha4.common.exceptions.UserDAOException;
import com.cyberha4.models.db.DbConnection;
import com.cyberha4.models.dao.interfaces.UserModel;
import com.cyberha4.models.oldclasses.Model;
import com.cyberha4.models.pojo.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.sql.ordering.antlr.Factory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserDAO implements UserModel {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("todolist");


    private static Logger logger = Logger.getLogger(UserDAO.class);

    private static final String SQL_FIND_USER = "SELECT * FROM users WHERE login=? AND password=?";

    private static final String SQL_CREATE_USER = "INSERT INTO users (login, password, role, email) VALUES (?,?,?,?)";
    private static final String SQL_USER_ID = "SELECT * FROM users WHERE id = ?";

    public User getUserByLoginAndPassword(String login, String password) throws UserDAOException {

        logger.debug(login + " " + password);
        User user = null;
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                logger.debug("find " + resultSet.getString("login"));
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getString("email")
                );
            }else{
                logger.debug(login + " " + password + " not found");
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDAOException();
        }
        return user;
    }

    public User getHUser(){
//        EntityManager criteriaBuilder = FACTORY.createEntityManager();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.select(root);
//        criteriaQuery.where(
//                criteriaBuilder.and(
//                        criteriaBuilder.equal(root.get("email"), email),
//                        criteriaBuilder.equal(root.get("password"), password)
//                )
//        );
//        List<User> users = entityManager.createQuery(criteriaQuery).getResultList();

//        EntityManager em = FACTORY.createEntityManager();
//        em.getTransaction().begin();
//        String login = "login";
//        //User user = em.createQuery("select u from Users u where login=");
//        User user = em.createQuery("from tasks " +
//                "where login = :login", User.class)
//                .setParameter("login",login)
//                .getSingleResult();
//
//        em.close();



        return null;
    }

    @Override
    public boolean checkExtistLoginOrEmail(String login, String email) throws UserDAOException {
        logger.debug("checkExtistLoginOrEmail");
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM users WHERE login=? OR email=?")) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            logger.error("getUserByLogin SQL exception", e);
            throw new UserDAOException();
        }
    }

    @Override
    public User getUserByLogin(String login) throws UserDAOException {
        logger.debug("getUserByLogin");
//        User user = null;
//        try(Connection connection = DbConnection.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE login=?")) {
//            preparedStatement.setString(1, login);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if(resultSet.next()){
//                logger.debug("find " + resultSet.getString("login"));
//                user = new User(
//                        resultSet.getInt("id"),
//                        resultSet.getString("login"),
//                        resultSet.getString("password"),
//                        resultSet.getString("role"),
//                        resultSet.getString("email")
//                );
//            }else{
//                logger.debug("getUserByLogin not found");
//            }
//        } catch (SQLException e) {
//            logger.error("getUserByLogin SQL exception", e);
//            throw new UserDAOException();
//        }

        EntityManager em = FACTORY.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(root.get("login"), "login")
                )
        );

        User user = em.createQuery(criteriaQuery).getSingleResult();

        return user;
    }

    public boolean registrationUser(String login, String password, String email) throws UserDAOException {
        try(Connection connection = Model.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_USER)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, "user");
            preparedStatement.setString(4, email);
            int count = preparedStatement.executeUpdate();
            if(count > 0){
                logger.debug("inserted " + count);
                return true;
            }else{
                logger.debug(login + " " + password + " not inserted");
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }

    public User getUserById(int id) throws UserDAOException {

        User user = null;
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_USER_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                logger.debug("find" + resultSet.getString("login"));
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getString("email")
                );
            }else{
                logger.debug(id + " not found");
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDAOException();
        }
        return user;
    }



    @Override
    public List<User> getAllUsers() {

    List<User> userList = new ArrayList<>();
    User user;

    try (Connection connection = DbConnection.getConnection();
         ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM users")){
        while(rs.next()){
            user = new User(rs.getInt("id"), rs.getString("login"),
                    rs.getString("password"), rs.getString("name"),
                    rs.getString("role"), rs.getString("email"),
                    rs.getBoolean("enabled")
                    );

            userList.add(user);
        }
    } catch (SQLException e) {
        logger.error("something wrong with sql", e);
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
        logger.error("something wrong (not sql)", e);
    }

    logger.debug("get All users count "+userList.size());
    return userList;
    }
}
