package com.cyberha4.controllers.mvc.User;

import com.cyberha4.common.exceptions.UserDAOException;
import com.cyberha4.controllers.LoginServlet;
import com.cyberha4.models.pojo.User;
import com.cyberha4.services.serviceinterface.UserServiceInterface;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
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
    public String login(Model model, HttpSession httpSession, HttpServletRequest request)
    {
        model.addAttribute("view", "clearlogin");
        return "container";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView autorise(@RequestParam(name = "login", defaultValue = "") String login,
                                 @RequestParam(name = "password", defaultValue = "") String password,
                                 final RedirectAttributes redirectAttributes,
                                 HttpServletRequest request,
                                 HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("container");


        try {
            User user = userService.authorise(login, password);
            if (user != null) {
                modelAndView.setViewName("redirect:task/list");
                session.setAttribute("id", user.getId());
                //modelAndView.addObject("id", user.getId());
                logger.error("auth");
            } else {
                modelAndView.addObject("view", "clearlogin");
                logger.error("not auth wrong pass or login");
                modelAndView.addObject("msg", "wrong password or login, try again " + request.getHeader("referer"));
                modelAndView.addObject("css", "danger");
            }
        } catch (UserDAOException e) {
            redirectAttributes.addFlashAttribute("msg", "Sorry, we have some technical trouble");
            redirectAttributes.addFlashAttribute("css", "danger");
            modelAndView.setViewName("error");
            logger.error("not auth error");
            e.printStackTrace();
        }

        return modelAndView;
    }

}
