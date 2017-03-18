package com.cyberha4.controllers.mvc.Task;

import com.cyberha4.models.pojo.User;
import org.springframework.security.core.context.SecurityContextImpl;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 15.03.2017.
 */
public class AbstractTaskController {
    protected User getUserFromSession(HttpSession session){
        SecurityContextImpl sci = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        return (User) sci.getAuthentication().getPrincipal();
    }
}
