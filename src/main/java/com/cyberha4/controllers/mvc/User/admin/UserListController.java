package com.cyberha4.controllers.mvc.User.admin;

import com.cyberha4.controllers.LoginServlet;
import com.cyberha4.models.pojo.Task;
import com.cyberha4.models.pojo.User;
import com.cyberha4.services.serviceinterface.UserServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by admin on 14.03.2017.
 */
@Controller
public class UserListController {
    private static Logger logger = Logger.getLogger(UserListController.class);

    private UserServiceInterface userService;

    @Autowired
    public void setUserService(UserServiceInterface userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/admin/users/list", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();

        System.out.println("Login ____________-------- "+userList.get(1).getLogin());

        model.addAttribute("userList", userList);
        model.addAttribute("view", "listusers");

        return "container";
    }

}
