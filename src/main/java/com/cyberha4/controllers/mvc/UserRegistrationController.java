package com.cyberha4.controllers.mvc;

import com.cyberha4.common.exceptions.UserDAOException;
import com.cyberha4.controllers.LoginServlet;
import com.cyberha4.models.pojo.User;
import com.cyberha4.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 06.03.2017.
 */
@Controller
public class UserRegistrationController {
    private static Logger logger = Logger.getLogger(LoginServlet.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration()
    {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView autorise(@RequestParam(name = "login", defaultValue = "") String login,
                                 @RequestParam(name = "password", defaultValue = "") String password,
                                 @RequestParam(name = "email", defaultValue = "") String email) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            if (userService.registration(login, password, email)) {
                logger.error("reg");
                modelAndView.setViewName("redirect:welcome");
            } else {
                modelAndView.setViewName("registration");
            }
        } catch (UserDAOException e) {
            modelAndView.addObject("error", "sorry, we have some problem, try it later");
            modelAndView.setViewName("error");
            logger.error("reg bad");
            e.printStackTrace();
        }

        return modelAndView;
    }
}
