package com.cyberha4.controllers.validators;

import com.cyberha4.models.pojo.Task;
import com.cyberha4.models.pojo.User;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * Created by admin on 08.03.2017.
 */
public class TaskFormValidator  implements Validator{
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("todolist");

    @Override
    public boolean supports(Class<?> clazz) {
        return Task.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Task task = (Task) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title", "This field is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "annotation", "annotation", "This field is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "text", "This field is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "typeId", "typeId", "Need to choice type");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "finished", "finished", "Need to set finished date");

//        if(task.getId() > 0) {
//            if (task.getStatusId() < 1 || task.getStatusId() > 5) {
//                //errors.rejectValue("statusId", "NotEmpty.userForm.status");
//                errors.reject("statusId", "incorrect status");
//                System.out.println("Status id = " + task.getStatusId());
//            }
//
//            //DateTimeFormatter.ofPattern("2017-01-01");
//        }

        if (task.getTypeId() < 1 || task.getTypeId() > 4) {
            //errors.rejectValue("statusId", "NotEmpty.userForm.status");
            errors.reject("typeId", "incorrect type");
            System.out.println("type id = " + task.getTypeId());
        }

        Calendar finished = Calendar.getInstance();
        finished.setTime(Date.valueOf(task.getFinished()));
        Calendar current = Calendar.getInstance();
        current.setTime(new Date(System.currentTimeMillis()));

        if(finished.before(current)){
            //errors.reject("finished", "incorrect date");

        }

    }

    private int getCountTasks(){
//        EntityManager em = FACTORY.createEntityManager();
//        em.getTransaction().begin();
//        String login = "login";
//        //User user = em.createQuery("select u from Users u where login=");
//        User user = em.createQuery("from users " +
//                "where login = :login", User.class)
//                .setParameter("login",login)
//                .getSingleResult();
//
//        em.close();

        return 1;
    }
}
