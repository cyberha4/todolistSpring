package com.cyberha4.controllers;

import com.cyberha4.common.exceptions.UserDAOException;
import com.cyberha4.models.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.cyberha4.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(LoginServlet.class);

    @Autowired
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
        logger.trace("loginGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            User user = userService.authorise(login,password);
            if (user != null) {
                req.getSession().setAttribute("userId",user.getId());
                req.getSession().setAttribute("role",user.getRole());
                logger.trace("auth");
                resp.sendRedirect("/todolist/listtasks");
            } else {
                logger.trace("noauth");
                req.getRequestDispatcher("/login.jsp?message=incorrect login or password (or both)").forward(req,resp);
            }
        } catch (UserDAOException e) {
            logger.error(e);
            resp.sendRedirect("/todolist/error.jsp?message=sorry something wrong with connection to DB");
        }
    }
}
