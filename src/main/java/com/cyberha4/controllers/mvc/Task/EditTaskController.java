package com.cyberha4.controllers.mvc.Task;

import com.cyberha4.common.exceptions.TaskDaoException;
import com.cyberha4.common.exceptions.TaskNotExistException;
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
public class EditTaskController extends AbstractTaskController{
    private TaskServiceInterface taskService;

    @Autowired
    public void setTaskService(TaskServiceInterface taskService) {
        this.taskService = taskService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new TaskFormValidator());
    }

    @RequestMapping(value = "/task/edit", method = RequestMethod.GET)
    public String editTask(Model model,
                           @RequestParam(name = "id", defaultValue = "0") int id) {
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("view", "edittask");

        if(id > 0){
            try {
                task = taskService.getTaskById(id);
                initModel(model);
            } catch (TaskNotExistException e) {
                model.addAttribute("msg", "Sorry we have some problems, try it later");
                model.addAttribute("css", "danger");
                model.addAttribute("view", "welcome");
            } catch (TaskDaoException e) {
                model.addAttribute("msg", "This task with id "+id+" not exist");
                model.addAttribute("css", "error");
                model.addAttribute("view", "welcome");
            }
        }

        initModel(model);
        return "container";
    }

    private void initModel(Model model){
        Map<String, String> statuses = new LinkedHashMap<>();
        statuses.put("1", "В процессе");
        statuses.put("2", "Завершена");
        statuses.put("3", "Просрочена");
        statuses.put("4", "Пропущена");

        model.addAttribute("statuses", statuses);

        Map<String, String> types = new LinkedHashMap<>();
        types.put("1", "Не очень важная");
        types.put("2", "Важная");
        types.put("3", "Очень важная");
        types.put("4", "Крайне важная");

        model.addAttribute("types", types);
    }

    private void initModelAndView(ModelAndView model){
        Map<String, String> statuses = new LinkedHashMap<>();
        statuses.put("1", "В процессе");
        statuses.put("2", "Завершена");
        statuses.put("3", "Просрочена");
        statuses.put("4", "Пропущена");

        model.addObject("statuses", statuses);

        Map<String, String> types = new LinkedHashMap<>();
        types.put("1", "Не очень важная");
        types.put("2", "Важная");
        types.put("3", "Очень важная");
        types.put("4", "Крайне важная");

        model.addObject("types", types);
    }

    @RequestMapping(value = "/task/edit", method = RequestMethod.POST)
    public ModelAndView editTaskPost(@ModelAttribute("task") @Validated
                                                 Task task,
                                     BindingResult result, Model model,
                                     HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("container");
        if (result.hasErrors()) {
            initModelAndView(modelAndView);
            modelAndView.addObject("view", "edittask");
            modelAndView.addObject("task", task);
            System.out.println("____________-------------- has Error");
            return modelAndView;
        }

        if (task.getId()>0){
            taskService.updateTaskOnId(task);
        }else {
            User userInSession = getUserFromSession(session);
            User user = new User();
            user.setId(userInSession.getId());
            task.setUser(user);
            taskService.insertTask(task);
        }

        System.out.println("_------------------not have Error");
        modelAndView.setViewName("redirect:/task/list");
        return modelAndView;
    }
}
