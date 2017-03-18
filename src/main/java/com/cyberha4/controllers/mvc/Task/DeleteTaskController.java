package com.cyberha4.controllers.mvc.Task;

/**
 * Created by admin on 13.03.2017.
 */

import com.cyberha4.controllers.validators.TaskFormValidator;
import com.cyberha4.models.pojo.Task;
import com.cyberha4.models.pojo.User;
import com.cyberha4.services.serviceinterface.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Created by admin on 06.03.2017.
 */
@Controller
public class DeleteTaskController {
    private TaskServiceInterface taskService;

    @Autowired
    public void setTaskService(TaskServiceInterface taskService) {
        this.taskService = taskService;
    }


    @RequestMapping(value = "/task/delete", method = RequestMethod.GET)
    public ModelAndView editTaskPost(@ModelAttribute("id") int id) {
        ModelAndView modelAndView = new ModelAndView("listtasks");
        modelAndView.addObject("message", "The tasks was delete");

            taskService.deleteTaskById(id);

        System.out.println("_Task was deleted");
        modelAndView.setViewName("redirect:/task/list");
        return modelAndView;
    }
}

