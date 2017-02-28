package controllers.filters;

import common.UsefulFunc;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;

/**
 * Created by admin on 26.02.2017.
 */
public class AvailableFilter implements Filter
{
    private FilterConfig config = null;
    private boolean active = false;
    private String freeRouts[];

    private HashSet<String> AllAvailableUrls = new HashSet<>();
    private HashSet<String> onlyNotAuthAvailableUrls = new HashSet<>();

    public void init (FilterConfig config) throws ServletException
    {
        this.config = config;
        String act = config.getInitParameter("active");
        if (act != null)
            active = (act.toUpperCase().equals("TRUE"));

        freeRouts = config.getInitParameter("freeRouts").split(";");
        initFreeRoutes(freeRouts);

    }

    private void initFreeRoutes(String[] urls){
        //Инициализируем урлы, которые доступны только незарегестрированным пользователям
        onlyNotAuthAvailableUrls.add("/todolist/login.jsp");
        onlyNotAuthAvailableUrls.add("/todolist/login");
        onlyNotAuthAvailableUrls.add("/todolist/registration.jsp");
        onlyNotAuthAvailableUrls.add("/todolist/registration");

        for(String url:
                urls){
            AllAvailableUrls.add(UsefulFunc.appRoute +"/" + url);
        }
        AllAvailableUrls.addAll(onlyNotAuthAvailableUrls);
        AllAvailableUrls.forEach(System.out::println);

    }

    public void doFilter (ServletRequest request, ServletResponse response,
                          FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String currentUrl = req.getRequestURI();
        System.out.println(currentUrl);
        System.out.println("Session user_id = " + req.getSession().getAttribute("userId") +
                " role = " + req.getSession().getAttribute("role"));
        //req.getSession().setAttribute("userId",1);

        if (!isFreeRoute(currentUrl)) {
            if (req.getSession().getAttribute("userId") == null) {
                System.out.println("not auth");
                resp.sendRedirect("login.jsp?message=this page available only to authorized users");
                return;
            } else {
                System.out.println("auth");
            }
        }

        if (isOnlyNotAuth(currentUrl) && req.getSession().getAttribute("userId") != null){
            resp.sendRedirect("error.jsp?message=for this page log out");
            return;
        }

        chain.doFilter(request, response);
    }

    private boolean isOnlyNotAuth(String url) {
        return onlyNotAuthAvailableUrls.contains(url);
    }

    public void destroy()
    {
        config = null;
    }

    private boolean isFreeRoute(String url){
        return AllAvailableUrls.contains(url);
    }
}

