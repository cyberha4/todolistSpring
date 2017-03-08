package com.cyberha4.controllers;

import com.cyberha4.common.exceptions.UserDAOException;
import org.apache.log4j.Logger;
import com.cyberha4.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 25.02.2017.
 */
public class RegistrationServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(RegistrationServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("on post");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        System.out.println(email);
//        try {
//            if(UserService.registration(login, password,email)){
//                logger.trace("true");
//                resp.sendRedirect("/login.jsp");
//            }else{
//                logger.trace("false");
//                req.getRequestDispatcher("/error.jsp").forward(req, resp);
//            }
//        } catch (UserDAOException e) {
//            e.printStackTrace();
//        }
    }
}
