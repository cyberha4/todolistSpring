package com.cyberha4.common.oldclasses;

import com.cyberha4.common.oldclasses.Jaxb.JaxbParser;
import com.cyberha4.common.oldclasses.Jaxb.Parser;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.lang.reflect.Method;

/**
 * Created by admin on 21.02.2017.
 */
public class WriteThread implements Runnable {
    private static final Logger logger = Logger.getLogger(WriteThread.class);
    static {
        DOMConfigurator.configure("log4j.xml");
    }
    private String className;
    private Parser parser = new JaxbParser();

    public WriteThread(String className) {
        this.className = className;
    }

    public void run() {
        System.out.println("run");
        fromXmlToDb();
    }

    private void fromXmlToDb() {

        try {
            System.out.println(className);
            //System.out.println(clazz.getName());
            Class clazz = Class.forName(className);

            Object obj = parser.getObject(clazz);

            Method method = clazz.getMethod("fromXmlToDb");
            method.invoke(obj);

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            logger.error("ClassNotFoundException", e);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            logger.error(e.getClass().getCanonicalName());
            e.printStackTrace();
        }
    }
}