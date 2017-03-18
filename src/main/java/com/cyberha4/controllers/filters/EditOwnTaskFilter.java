package com.cyberha4.controllers.filters;

import com.cyberha4.services.TasksService;
import com.cyberha4.services.serviceinterface.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 27.02.2017.
 */

public class EditOwnTaskFilter implements Filter {
    private TaskServiceInterface tasksService = new TasksService();
    //@Autowired
    //public void setTasksService(TaskServiceInterface tasksService) {
    //    this.tasksService = tasksService;
    //}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(filterConfig.getServletContext());
        AutowireCapableBeanFactory bf = ctx.getAutowireCapableBeanFactory();
        bf.autowireBean(this);

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        Integer userId = (Integer) req.getSession().getAttribute("id");
        //Integer taskId = Integer.parseInt(req.getParameter("id"));
        String paramId = req.getParameter("id");
        Integer taskId = (paramId != null) ? Integer.parseInt(paramId) : 0;

        System.out.println("its filter own task task_id = "+taskId + " user_id = " + userId);

        if (taskId != 0 && !tasksService.isUsersTask(userId, taskId)){
            System.out.println("not your task");
            resp.sendRedirect("error.jsp?message=its not your task or taskId is incorrect");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }


}
