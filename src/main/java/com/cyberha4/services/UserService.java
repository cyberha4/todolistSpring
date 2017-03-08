package com.cyberha4.services;

import com.cyberha4.common.exceptions.UserDAOException;
import com.cyberha4.models.dao.UserDAO;
import com.cyberha4.models.dao.UserModel;
import com.cyberha4.models.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{

    private UserModel userDAO;

    @Autowired
    public UserService(UserModel userDAO) {
        this.userDAO = userDAO;
    }

    public User authorise(String login, String password) throws UserDAOException {
            return userDAO.getUserByLoginAndPassword(login, password);
    }



    public boolean registration(String login, String password, String email) throws UserDAOException {
        return userDAO.registrationUser(login, password,email);
    }

}
