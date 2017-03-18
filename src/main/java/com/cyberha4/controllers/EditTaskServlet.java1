package com.cyberha4.controllers;

import com.cyberha4.common.UsefulFunc;
import com.cyberha4.models.pojo.Task;
import com.cyberha4.models.pojo.User;
import org.apache.log4j.Logger;
import com.cyberha4.services.TasksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 27.02.2017.
 */
public class EditTaskServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(EditTaskServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task;
        if (req.getParameter("id") != null) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            task = TasksService.getTaskById(id);
        } else {
            task = new Task();
        }
            System.out.println(task.getTitle());
            req.setAttribute("task", task);

            req.getRequestDispatcher("edittask.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("on edit task");
        String tskId = req.getParameter("id");
        int id = (tskId.equals(""))?0:Integer.parseInt(req.getParameter("id"));

        Task task = new Task();
        task.setTitle(req.getParameter("title"));
        task.setAnnotation(req.getParameter("annotation"));
        task.setText(req.getParameter("text"));
        task.setStatusId(Integer.parseInt(req.getParameter("status")));
        task.setTypeId(Integer.parseInt(req.getParameter("status")));
        task.setFinishedTime(Integer.parseInt(req.getParameter("finished")));
        System.out.println("on edit task " + task.getTitle());
        System.out.println(id);
        int count = 0;
        if (id == 0) {
            logger.debug("insert");
            User user = new User();
            user.setId( (Integer) req.getSession().getAttribute("userId"));
            task.setUser(user);
            count = TasksService.insertTask(task);
        } else {
            logger.debug("update");
            task.setId(id);
            count = TasksService.updateTaskOnId(task);
        }
        if (count != 0) {
            logger.trace("true");
            resp.sendRedirect(UsefulFunc.appRoute+"/listtasks");
        } else {
            logger.trace("false");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);

        }
    }
}
