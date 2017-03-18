package com.cyberha4.controllers;

import com.cyberha4.models.pojo.Task;
import com.cyberha4.services.TasksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 25.02.2017.
 */
public class ListTasksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = (Integer) req.getSession().getAttribute("userId");
        List<Task> tasksList = TasksService.getAllTasks(id);
            req.setAttribute("tasksList", tasksList);
            req.getRequestDispatcher("/listtasks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
