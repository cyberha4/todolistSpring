package com.cyberha4.services;

import com.cyberha4.models.dao.TasksDao;
import com.cyberha4.models.dao.interfaces.TasksModel;
import com.cyberha4.models.pojo.Task;
import com.cyberha4.models.pojo.User;
import com.cyberha4.services.serviceinterface.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by admin on 25.02.2017.
 */
@Service
public class TasksService implements TaskServiceInterface{
    private TasksModel tasksDao = new TasksDao();

//    @Autowired
//    public void setTasksDao(TasksModel tasksDao) {
//        this.tasksDao = tasksDao;
//    }

    public List<Task> getAllTasks(int id) {
        return tasksDao.getAllTasks(id);
    }

    public Task getTaskById(Integer id) {
        return tasksDao.getTaskById(id);
    }



    public boolean isUsersTask(Integer userId, Integer taskId) {
        if (userId < 1 || taskId <1)
            return false;

        User user = tasksDao.getTaskById(taskId).getUser();
        System.out.println(user.getLogin());
        return user.getId() == userId;
    }

    public int insertTask(Task task) {
        task.setStatusId(1);
        return tasksDao.insertTask(task);
    }

    public int updateTaskOnId(Task task) {
        return tasksDao.updateTaskOnId(task);
    }

    public int deleteTaskById(int id){
        return tasksDao.deleteTask(id);
    }
}
