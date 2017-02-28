import DataObjects.Status;
import models.Model;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

/**
 * Created by admin on 23.02.2017.
 */
public class TestFunctions {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, NamingException {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.stream().filter(test -> test > 2).forEach(System.out::println);

        //AnnotationConfiguration aconf = new AnnotationConfiguration()
        //        .addAnnotatedClass(Status.class);
        //Configuration conf = aconf.configure();

        Class.forName("com.mysql.jdbc.Driver");
        /* Hibernate
        SessionFactory sessions = new Configuration().addAnnotatedClass(Status.class).configure().buildSessionFactory();
        Session session = sessions.openSession();
        //Status status = (Status)session.get(Status.class, 2);

        Status st = new Status();
        session.beginTransaction();
        st.setStatus("testStatus of hiber");
        session.saveOrUpdate(st);
        session.getTransaction().commit();

        session.close();
        //System.out.println(status.getStatus());

        */
        Context initContext= new InitialContext();
        DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/TEST");
        Connection conn = ds.getConnection();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM statuses");
        rs.next();
        System.out.println(rs.getInt("id"));

    }
}
