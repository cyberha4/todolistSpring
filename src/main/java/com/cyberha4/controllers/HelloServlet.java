package com.cyberha4.controllers;

import com.cyberha4.common.UsefulFunc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 23.02.2017.
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        //if (UsefulFunc.sendEmail) {
        //    UsefulFunc.sendMail("proffi99@mail.ru", "test mail", "test text");
        //}
        Context initContext= null;
        try {
            initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/TEST");
            Connection conn = ds.getConnection();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM statuses");
            rs.next();
            System.out.println(rs.getInt("id"));
            pw.append(rs.getString(2));

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //req.getRequestDispatcher("hello.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsefulFunc.sendEmail = !UsefulFunc.sendEmail;
        System.out.println(UsefulFunc.sendEmail);
    }
}
