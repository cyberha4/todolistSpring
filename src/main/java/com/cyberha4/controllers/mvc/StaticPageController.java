package com.cyberha4.controllers.mvc;

import com.cyberha4.models.pojo.Task;
import com.cyberha4.services.TasksService;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by admin on 08.03.2017.
 */
@Controller
public class StaticPageController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomePage(HttpSession session) {
        Enumeration<String> names = session.getAttributeNames();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        while(names.hasMoreElements())
            System.out.println(names.nextElement());
        SecurityContextImpl sci = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        if (sci != null) {
            UserDetails cud = (UserDetails) sci.getAuthentication().getPrincipal();
            System.out.println(cud.getUsername());
        }

        return "welcome";

    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorPage(Model model) {
        model.addAttribute("view", "error");
        return "container";
    }
}
