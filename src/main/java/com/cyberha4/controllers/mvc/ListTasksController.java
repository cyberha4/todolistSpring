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
 * Created by admin on 06.03.2017.
 */
@Controller
public class ListTasksController {
    @RequestMapping(value = "/listtasks", method = RequestMethod.GET)
    public String showAllTasks(Model model, HttpSession httpSession) {
        Integer id = (Integer) httpSession.getAttribute("id");
        List<Task> tasksList = TasksService.getAllTasks(id);
        model.addAttribute("tasksList", tasksList);

        return "listtasks";
    }
}
