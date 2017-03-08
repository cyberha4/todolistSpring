package com.cyberha4.services;

import com.cyberha4.common.exceptions.UserDAOException;
import com.cyberha4.models.pojo.User;

/**
 * Created by admin on 07.03.2017.
 */
public interface UserServiceInterface {
    abstract public User authorise(String login, String password) throws UserDAOException;

    abstract public boolean registration(String login, String password, String email) throws UserDAOException;
}
