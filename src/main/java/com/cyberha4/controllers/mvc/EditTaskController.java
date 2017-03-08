package com.cyberha4.controllers.mvc;

import com.cyberha4.controllers.validators.TaskFormValidator;
import com.cyberha4.models.pojo.Task;
import com.cyberha4.services.TasksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 06.03.2017.
 */
@Controller
public class EditTaskController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new TaskFormValidator());
    }

    @RequestMapping(value = "/task/edit", method = RequestMethod.GET)
    public String editTask(Model model) {
        Task task = TasksService.getTaskById(2);
        task = new Task();
        model.addAttribute("task", task);

        Map<String, String> statuses = new LinkedHashMap<String, String>();
        //country.put("0", "United Stated");
        statuses.put("1", "China");
        statuses.put("2", "Singapore");
        statuses.put("3", "Malaysia");
        model.addAttribute("statuses", statuses);

        return "edittask";
    }

    @RequestMapping(value = "/task/edit", method = RequestMethod.POST)
    public ModelAndView editTaskPost(@ModelAttribute("task") @Validated
                                                 Task task,
                                     BindingResult result, Model model) {
        ModelAndView modelAndView = new ModelAndView("edittask");
        modelAndView.addObject("task", task);
        if (result.hasErrors()) {
            //populateDefaultModel(model);
            System.out.println("____________-------------- has Error");
            return modelAndView;
        }

        System.out.println("_------------------not have Error");
        //Task task = TasksService.getTaskById(1);
        //model.addAttribute("task", task);
        return modelAndView;
    }
}
