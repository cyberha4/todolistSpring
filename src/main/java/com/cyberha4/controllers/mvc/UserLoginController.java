package com.cyberha4.controllers.mvc;

import com.cyberha4.common.exceptions.UserDAOException;
import com.cyberha4.controllers.LoginServlet;
import com.cyberha4.models.dao.UserDAO;
import com.cyberha4.models.pojo.User;
import com.cyberha4.services.UserServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 06.03.2017.
 */
@Service
@Controller
@SessionAttributes({"id", "name"})
public class UserLoginController {
    private static Logger logger = Logger.getLogger(LoginServlet.class);

    private UserServiceInterface userService;

    @Autowired
    public void setUserService(UserServiceInterface userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpSession httpSession)
    {
        model.addAttribute("name", "name");
        System.out.println("!!!!!!!!!!!!!!!!" + httpSession.getAttribute("name"));

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView autorise(@RequestParam(name = "login", defaultValue = "") String login,
                                 @RequestParam(name = "password", defaultValue = "") String password) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            User user = userService.authorise(login, password);
            if (user != null) {
                modelAndView.addObject("id", user.getId());
                logger.error("auth");
                modelAndView.setViewName("login");
            } else
                modelAndView.setViewName("error");
        } catch (UserDAOException e) {
            modelAndView.setViewName("error");
            logger.error("not auth");
            e.printStackTrace();
        }

        return modelAndView;
    }

}
