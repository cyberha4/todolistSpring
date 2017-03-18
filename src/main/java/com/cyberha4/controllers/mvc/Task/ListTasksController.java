package com.cyberha4.controllers.mvc.Task;

import com.cyberha4.models.pojo.Task;
import com.cyberha4.models.pojo.User;
import com.cyberha4.services.TasksService;
import com.cyberha4.services.serviceinterface.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 06.03.2017.
 */
@Controller
public class ListTasksController extends AbstractTaskController{
    private TaskServiceInterface taskService;

    @Autowired
    public void setTaskService(TaskServiceInterface taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/task/list", method = RequestMethod.GET)
    public String showAllTasks(Model model, HttpSession session) {
        //Integer id = (Integer) httpSession.getAttribute("id");
        User user = getUserFromSession(session);

        List<Task> tasksList = taskService.getAllTasks(user.getId());
        //System.out.println(tasksList.get(1).getUser().getLogin());
        model.addAttribute("tasksList", tasksList);
        model.addAttribute("view", "listtasks");

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
}
