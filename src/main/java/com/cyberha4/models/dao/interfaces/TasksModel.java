package com.cyberha4.models.dao.interfaces;

import com.cyberha4.common.exceptions.TaskDaoException;
import com.cyberha4.common.exceptions.TaskNotExistException;
import com.cyberha4.models.entity.TaskEntity;
import com.cyberha4.models.entity.UserEntity;
import com.cyberha4.models.pojo.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by admin on 10.03.2017.
 */
public interface TasksModel {
    public List<TaskEntity> getAllTasks(int id);
    public TaskEntity getTaskById(Integer id) throws TaskNotExistException, TaskDaoException;
    public boolean isUsersTask(Integer userId, Integer taskId);
    public int insertTask(TaskEntity task);
    public int updateTaskOnId(TaskEntity task);
    public int deleteTask(int id);
}
