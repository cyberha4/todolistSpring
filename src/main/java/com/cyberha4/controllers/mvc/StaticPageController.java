package com.cyberha4.controllers.mvc;

import com.cyberha4.models.pojo.Task;
import com.cyberha4.services.TasksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by admin on 08.03.2017.
 */
@Controller
public class StaticPageController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomePage() {
        return "welcome";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorPage() {
        return "error";
    }
}
