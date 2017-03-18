package com.cyberha4.models.dao.interfaces;

import com.cyberha4.common.exceptions.UserDAOException;
import com.cyberha4.models.pojo.User;

import java.util.List;

/**
 * Created by admin on 07.03.2017.
 */
public interface UserModel {
    public User getUserByLoginAndPassword(String login, String password) throws UserDAOException;
    public User getUserByLogin(String login) throws UserDAOException;
    public boolean registrationUser(String login, String password, String email) throws UserDAOException;
    public User getUserById(int id) throws UserDAOException;
    public List<User> getAllUsers();

    boolean checkExtistLoginOrEmail(String login, String email) throws UserDAOException;
}
