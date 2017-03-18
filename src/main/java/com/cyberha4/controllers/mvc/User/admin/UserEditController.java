package com.cyberha4.controllers.mvc.User.admin;

import com.cyberha4.models.pojo.User;
import com.cyberha4.services.serviceinterface.UserServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by admin on 14.03.2017.
 */

@Controller
public class UserEditController {
    private static Logger logger = Logger.getLogger(UserListController.class);

    private UserServiceInterface userService;

    @Autowired
    public void setUserService(UserServiceInterface userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/admin/users/edit", method = RequestMethod.GET)
    public String showUserForEdit(Model model) {

        model.addAttribute("user", "");
        model.addAttribute("view", "edituser");

        return "container";
    }

    @RequestMapping(value = "/admin/users/edit", method = RequestMethod.POST)
    public String editUser(Model model) {

        model.addAttribute("user", "");
        model.addAttribute("view", "edituser");

        return "container";
    }



}
