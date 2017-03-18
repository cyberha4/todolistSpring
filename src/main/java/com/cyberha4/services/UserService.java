package com.cyberha4.services;

import com.cyberha4.common.exceptions.UserDAOException;
import com.cyberha4.models.dao.interfaces.UserModel;
import com.cyberha4.models.pojo.GrantedAuthorityImpl;
import com.cyberha4.models.pojo.User;
import com.cyberha4.services.serviceinterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceInterface, UserDetailsService {

    private UserModel userDAO;

    @Autowired
    public UserService(UserModel userDAO) {
        this.userDAO = userDAO;
    }

    public User authorise(String login, String password) throws UserDAOException {
            return userDAO.getUserByLoginAndPassword(login, password);
    }



    public boolean registration(String login, String password, String email) throws UserDAOException {
        return !isExistLoginOrEmail(login, email) && userDAO.registrationUser(login, password, email);
    }

    @Override
    public boolean isExistLoginOrEmail(String login, String email) throws UserDAOException {
        return userDAO.checkExtistLoginOrEmail(login, email);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        User user = null;
        try {
            user = userDAO.getUserByLogin(username);
            if(user.getRole().equals("ROLE_MODERATOR") || user.getRole().equals("ROLE_ADMIN")) {
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MODERATOR"));
            }
            if (user.getRole().equals("ROLE_ADMIN")){
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }

            return new User(user.getId(),username, user.getPassword(), grantedAuthorities);
        } catch (UserDAOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<User> getAllUsers(){
         return userDAO.getAllUsers();
    }

    @Override
    public int addUser() {
        return 0;
    }

    @Override
    public int UpdateUserById() {
        return 0;
    }

    @Override
    public int deleteUserById() {
        return 0;
    }
}
