import Jaxb.JaxbParser;

import javax.xml.bind.JAXBException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by admin on 21.02.2017.
 */
public class WriteThread implements Runnable {
    private String className;
    private Jaxb.Parser parser = new JaxbParser();

    public WriteThread(String className) {
        this.className = className;
    }

    public void run() {
        try {
            fromXmlToDb();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void fromXmlToDb() throws ClassNotFoundException, JAXBException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //className = entry.getName().substring(0, entry.getName().length()-4);
        System.out.println(className);
        //if (className.equals("models.Users") || className.equals("models.Tasks") || className.equals("models.Types")) {
            Class clazz = Class.forName(className);
            Object obj = parser.getObject(clazz);

            Method method = clazz.getMethod("fromXmlToDb");
            method.invoke(obj);
    }
}