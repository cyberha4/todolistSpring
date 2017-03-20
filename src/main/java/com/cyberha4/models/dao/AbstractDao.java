package com.cyberha4.models.dao;

import com.cyberha4.models.entity.TaskEntity;
import com.cyberha4.models.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by admin on 19.03.2017.
 */
public class AbstractDao {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("todolist");

    public static EntityManager getEntityManager (){
        return FACTORY.createEntityManager();
    }

    public static int saveOrUpdate(Object obj){
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(obj);
            transaction.commit();

        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        em.close();
        return 1;
    }
//    public static <T> TaskEntity findById(T entity, int id){
//        EntityManager em = getEntityManager();
//        return em.find(TaskEntity.class, id);
//    }
}
