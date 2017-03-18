package com.cyberha4;

import com.cyberha4.common.exceptions.UserDAOException;
import com.cyberha4.common.oldclasses.DataObjects.Status;
import com.cyberha4.models.dao.UserDAO;
import com.cyberha4.models.entity.UserEntity;
import com.cyberha4.models.pojo.User;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.*;
import javax.sql.DataSource;
import java.net.UnknownServiceException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 * Created by admin on 23.02.2017.
 */
public class TestFunctions {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("todolist");

    public static void main(String[] args) throws SQLException, ClassNotFoundException, NamingException, UserDAOException {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.stream().filter(test -> test > 2).forEach(System.out::println);

        //AnnotationConfiguration aconf = new AnnotationConfiguration()
        //        .addAnnotatedClass(Status.class);
        //Configuration conf = aconf.configure();

        Class.forName("com.mysql.jdbc.Driver");
//        //Hibernate
//        SessionFactory sessions = new Configuration().addAnnotatedClass(Status.class).configure().buildSessionFactory();
//        Session session = sessions.openSession();
//        //Status status = (Status)session.get(Status.class, 2);
//
//        Status st = new Status();
//        session.beginTransaction();
//        st.setStatus("testStatus of hiber");
//        session.saveOrUpdate(st);
//        session.getTransaction().commit();
//
//        session.close();
//        //System.out.println(status.getStatus());
//
//
//        Context initContext= new InitialContext();
//        DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/TEST");
//        Connection conn = ds.getConnection();
//
//        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM statuses");
//        rs.next();
//        System.out.println(rs.getInt("id"));

//        EntityManager em = FACTORY.createEntityManager();


//        EntityManager em = FACTORY.createEntityManager();
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.select(root);
//        criteriaQuery.where(
//                criteriaBuilder.and(
//                        criteriaBuilder.equal(root.get("login"), "login")
//                )
//        );
//        User user = em.createQuery(criteriaQuery).getSingleResult();
//
//        System.out.println("------------------------"+user.getLogin());

        DateTimeFormatter date = DateTimeFormatter.ofPattern("2017-01-01");
        LocalDate localDate = LocalDate.now();

        new java.text.SimpleDateFormat("yyyy-MM-dd");

        java.text.SimpleDateFormat sdf =

                new java.text.SimpleDateFormat("yyyy-MM-dd");

        Calendar c2 = Calendar.getInstance(); c2.setTime(java.sql.Date.valueOf("2017-01-01"));
        Calendar c1 = Calendar.getInstance(); c2.setTime(java.sql.Date.valueOf("2017-01-2"));
        System.out.print(c1.after(c2));

        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        UserEntity userEntity = em.find(UserEntity.class, 1);
        System.out.println("login -------- "+userEntity.getLogin());

        {
            try {
                User user2 = (new UserDAO()).getUserById(1);
                user2.setEmail("sdfsdfsd");
                System.out.println(user2.getEmail());
            } catch (Exception e){
                System.out.println("!!!!!!!!!!!!EXCEPTION!");
            }
        }

        UserEntity user = new UserEntity("hyberLogin23", "passdfgdfg", "name", "role", "email@asd23",
                true);
        user.setId(21);

        try {
            transaction.begin();
            UserEntity userEntity1 = em.merge(user);
            transaction.commit();
        } catch (Exception e){
            System.out.println("11111111111111111111111111111111");
            e.printStackTrace();
        }
        em.close();
    }
}
