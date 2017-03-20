package com.cyberha4.services;

import com.cyberha4.common.converter.ConveterPojoEntity;
import com.cyberha4.common.exceptions.TaskDaoException;
import com.cyberha4.common.exceptions.TaskNotExistException;
import com.cyberha4.models.dao.interfaces.TasksModel;
import com.cyberha4.models.entity.TaskEntity;
import com.cyberha4.models.pojo.Task;
import com.cyberha4.services.serviceinterface.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 25.02.2017.
 */
@Service
public class TasksService implements TaskServiceInterface{
    private TasksModel tasksDao;

    @Autowired
    public void setTasksDao(TasksModel tasksDao) {
        this.tasksDao = tasksDao;
    }

    public List<Task> getAllTasks(int id) {
        List<Task> tasks = new ArrayList<>();

        List<TaskEntity> listEntity = tasksDao.getAllTasks(id);
        for (TaskEntity taskEntity : listEntity) {
            tasks.add(ConveterPojoEntity.TaskEntityToPojo(taskEntity));
        }
        return tasks;

    }

    public Task getTaskById(Integer id) throws TaskNotExistException, TaskDaoException {
        TaskEntity entity = null;
            entity = tasksDao.getTaskById(id);
            return ConveterPojoEntity.TaskEntityToPojo(entity);
    }


    public boolean isUsersTask(Integer userId, Integer taskId) {
        if (userId < 1 || taskId <1)
            return false;

        return true;

//        User user = tasksDao.getTaskById(taskId).getUser();
//        System.out.println(user.getLogin());
//        return user.getId() == userId;
    }

    public int insertTask(Task task) {
        task.setStatusId(1);
        return tasksDao.insertTask(ConveterPojoEntity.TaskPojoToEntity(task));
    }

    public int updateTaskOnId(Task task) {

        return tasksDao.updateTaskOnId(ConveterPojoEntity.TaskPojoToEntity(task));
    }

    public int deleteTaskById(int id){
        return tasksDao.deleteTask(id);
    }
}
