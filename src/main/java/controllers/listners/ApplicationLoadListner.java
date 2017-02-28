package controllers.listners;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by admin on 26.02.2017.
 */
public class ApplicationLoadListner implements ServletContextListener {
    private static Logger logger = Logger.getLogger(ApplicationLoadListner.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.trace("Sait started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.trace("Sait was dead");
        System.out.println("----------------------------------sait was dead-------------------------------------");
    }
}
