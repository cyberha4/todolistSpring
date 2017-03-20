package com.cyberha4.common.converter;

import com.cyberha4.models.entity.TaskEntity;
import com.cyberha4.models.entity.UserEntity;
import com.cyberha4.models.pojo.Task;
import com.cyberha4.models.pojo.User;

/**
 * Created by admin on 19.03.2017.
 */
public class ConveterPojoEntity {
    public static TaskEntity TaskPojoToEntity(Task task){
        UserEntity user = new UserEntity("hyberLogin23", "passdfgdfg", "name", "role", "email@asd23",
                true);
        user.setId(1);
        return new TaskEntity(task.getId(), user, task.getStatusId(), task.getTypeId(), task.getTitle(),
                task.getAnnotation(), task.getText(), task.getCreate(), task.getFinished());
    }

    public static Task TaskEntityToPojo(TaskEntity e){
        User user = new User("hyberLogin23", "passdfgdfg", "name", "role", "email@asd23",
                true);
        //User user = new User()
        Task task = new Task(e.getId(),user,e.getStatusId(),e.getTypeId(),e.getTitle(),
                e.getAnnotation(),e.getText(),e.getCreate(),e.getFinished());

        return task;

//        return new TaskEntity(user, task.getStatusId(), task.getTypeId(), task.getTitle(),
//                task.getAnnotation(), task.getText(), task.getCreate(), task.getFinished());
    }

}
