package com.cyberha4.services.serviceinterface;

import com.cyberha4.common.exceptions.UserDAOException;
import com.cyberha4.models.pojo.User;

import java.util.List;

/**
 * Created by admin on 07.03.2017.
 */
public interface UserServiceInterface {
    public User authorise(String login, String password) throws UserDAOException;

    public boolean registration(String login, String password, String email) throws UserDAOException;
    public boolean isExistLoginOrEmail(String login, String email) throws UserDAOException;
    public List<User> getAllUsers();
    public int addUser();
    public int UpdateUserById();
    public int deleteUserById();
}
