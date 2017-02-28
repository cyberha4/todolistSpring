package controllers.listners;

import common.UsefulFunc;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by admin on 26.02.2017.
 */
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    private static Logger logger = Logger.getLogger(SessionListener.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        logger.trace("This id was login on sait id = " + event.getValue());
        isAdmin(event);
        //UsefulFunc.sendMail("proffi99@mail.ru", "Admin was detected", "Warning Admin was detected");
        if (UsefulFunc.sendEmail && isAdmin(event)) {
            UsefulFunc.sendMail("proffi99@mail.ru", "Admin was detected", "Warning Admin was detected");
            logger.debug("This is admin The mail was send");
        } else {logger.debug("This isnt admin dont send mail");}

    }

    private boolean isAdmin(HttpSessionBindingEvent event){
        logger.debug(event.getName() +" "+ event.getValue());
        return event.getName().equals("role") && event.getValue().equals("admin");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.trace("This id was goo out from sait id = " + se.getSession().getAttribute("userId"));
    }
}
