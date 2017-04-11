package com.cyberha4.services;

import com.cyberha4.common.converter.ConveterPojoEntity;
import com.cyberha4.common.exceptions.TaskDaoException;
import com.cyberha4.common.exceptions.TaskNotExistException;
import com.cyberha4.models.dao.interfaces.TasksModel;
import com.cyberha4.models.entity.TaskEntity;
import com.cyberha4.models.pojo.Task;
import com.cyberha4.models.repository.TaskRepository;
import com.cyberha4.services.serviceinterface.TaskServiceInterface;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 25.02.2017.
 */
@Service
@Repository
@Transactional

public class TasksService implements TaskServiceInterface{
    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private TasksModel tasksDao;

    @Autowired
    public void setTasksDao(TasksModel tasksDao) {
        this.tasksDao = tasksDao;
    }

    public List<Task> getAllTasks(int id) {
        List<Task> tasks = new ArrayList<>();

        Iterable<TaskEntity> taskEntities = taskRepository.findAll();
        for (TaskEntity taskEntity : taskEntities) {
            tasks.add(ConveterPojoEntity.TaskEntityToPojo(taskEntity));
        }

//        List<TaskEntity> listEntity = tasksDao.getAllTasks(id);
//        for (TaskEntity taskEntity : listEntity) {
//            tasks.add(ConveterPojoEntity.TaskEntityToPojo(taskEntity));
//        }
        return tasks;

    }

    public Task getTaskById(Integer id) throws TaskNotExistException, TaskDaoException {
        List<TaskEntity> entity = null;
            //entity = tasksDao.getTaskById(id);
        entity = taskRepository.findById(id);
            return ConveterPojoEntity.TaskEntityToPojo(entity.get(0));
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
        //return tasksDao.insertTask(ConveterPojoEntity.TaskPojoToEntity(task));
        TaskEntity taskEntity = taskRepository.save(ConveterPojoEntity.TaskPojoToEntity(task));
        return taskEntity != null ? 1 : 0;
    }

    public int updateTaskOnId(Task task) throws ObjectOptimisticLockingFailureException {
        TaskEntity entity = ConveterPojoEntity.TaskPojoToEntity(task);
        //entity = taskRepository.findOne(task.getId());
        //entity.setVersion(1L);
            TaskEntity taskEntity = taskRepository.save(entity);
            return 1;
//        return tasksDao.updateTaskOnId(ConveterPojoEntity.TaskPojoToEntity(task));
//
    }

    public int deleteTaskById(int id){
        return tasksDao.deleteTask(id);
    }


}
