package com.cyberha4.common.oldclasses;

import com.cyberha4.common.oldclasses.Jaxb.JaxbParser;
import com.cyberha4.common.oldclasses.Jaxb.Parser;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.lang.reflect.Method;

/**
 * Created by admin on 20.02.2017.
 */
public class ReadThread implements Runnable {
    private static final Logger logger = Logger.getLogger(ReadThread.class);
    static {
        DOMConfigurator.configure("log4j.xml");
    }
    private String tableName;

    public ReadThread(String tableName) {
        this.tableName = tableName;
    }

    public void run() {
        parseDbToXml();
    }

    private void parseDbToXml() {
        Parser parser = new JaxbParser();
        Class clazz = null;
        try {
            clazz = Class.forName(JaxbParser.locationModels+"."+tableName);
            System.out.println(JaxbParser.locationModels+"."+tableName);
            Method m = clazz.getMethod("setAllForSer");
            Object model = clazz.newInstance();
            m.invoke(model);
            parser.saveObject(model);
        } catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException", e);
            e.printStackTrace();
        } catch (Exception e) {
            logger.error(e.getClass().getCanonicalName());
            e.printStackTrace();
        }


    }
}
