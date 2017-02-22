import Jaxb.JaxbParser;

import javax.xml.bind.JAXBException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by admin on 20.02.2017.
 */
public class ReadThread implements Runnable {
    private String tableName;

    public ReadThread(String tableName) {
        this.tableName = tableName;
    }

    public void run() {
        try {
            parseDbToXml();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void parseDbToXml() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, JAXBException {
        Jaxb.Parser parser = new JaxbParser();
        Class clazz = Class.forName(JaxbParser.locationModels+"."+tableName);
        Method m = clazz.getMethod("setAllForSer");
        Object model = clazz.newInstance();
        m.invoke(model);
        parser.saveObject(model);
    }
}
