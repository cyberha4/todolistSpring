package com.cyberha4.services.serviceinterface;

import com.cyberha4.common.exceptions.TaskDaoException;
import com.cyberha4.common.exceptions.TaskNotExistException;
import com.cyberha4.models.pojo.Task;
import org.hibernate.dialect.lock.OptimisticEntityLockException;

import java.util.List;

/**
 * Created by admin on 10.03.2017.
 */
public interface TaskServiceInterface {
    public List<Task> getAllTasks(int id);
    public Task getTaskById(Integer id) throws TaskNotExistException, TaskDaoException;
    public boolean isUsersTask(Integer userId, Integer taskId);
    public int insertTask(Task task);
    public int updateTaskOnId(Task task) throws OptimisticEntityLockException;
    public int deleteTaskById(int id);
}
