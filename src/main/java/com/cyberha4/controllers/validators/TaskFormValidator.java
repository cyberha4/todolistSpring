package com.cyberha4.controllers.validators;

import com.cyberha4.models.pojo.Task;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by admin on 08.03.2017.
 */
public class TaskFormValidator  implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Task.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Task task = (Task) target;

        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.userForm.name");
        System.out.println("Status id = "+task.getStatusId());

        if(task.getStatusId() < 1){
            //errors.rejectValue("statusId", "NotEmpty.userForm.status");
            errors.reject("statusId", "bad");
        }

    }
}
