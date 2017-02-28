package controllers.filters;

import services.TasksService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 27.02.2017.
 */
public class EditOwnTaskFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        Integer userId = (Integer) req.getSession().getAttribute("userId");
        //Integer taskId = Integer.parseInt(req.getParameter("id"));
        String paramId = req.getParameter("id");
        Integer taskId = (paramId != null) ? Integer.parseInt(paramId) : 0;

        System.out.println("its filter own task task_id = "+taskId);

        if (taskId != 0 && !TasksService.isUsersTask(userId, taskId)){
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
