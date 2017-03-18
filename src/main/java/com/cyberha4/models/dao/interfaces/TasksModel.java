package com.cyberha4.models.dao.interfaces;

import com.cyberha4.models.pojo.Task;

import java.util.List;

/**
 * Created by admin on 10.03.2017.
 */
public interface TasksModel {
    public List<Task> getAllTasks(int id);
    public Task getTaskById(Integer id);
    public boolean isUsersTask(Integer userId, Integer taskId);
    public int insertTask(Task task);
    public int updateTaskOnId(Task task);
    public int deleteTask(int id);
}
