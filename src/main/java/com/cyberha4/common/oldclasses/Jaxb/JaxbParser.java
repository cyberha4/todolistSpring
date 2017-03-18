package com.cyberha4.common.oldclasses.Jaxb;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by admin on 19.02.2017.
 */

public class JaxbParser implements Parser {
    public static final Logger logger = Logger.getLogger(JaxbParser.class);
    static {
        DOMConfigurator.configure("log4j.xml");
    }
    public static final String pathToSrialize = "Xml";
    public static final String locationModels = "com/cyberha4/models";


    public Object getObject(Class c) {
        File file = new File(pathToSrialize+"/"+c.getCanonicalName()+".xml");
        Object object = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            object = unmarshaller.unmarshal(file);
            System.out.println("unmarshal");
        } catch (JAXBException e) {
            logger.error("Problems with JAXB", e);
            e.printStackTrace();
        }
        return object;
    }

    public void saveObject(Object o) {
        File file = new File(pathToSrialize+"/"+o.getClass().getCanonicalName()+".xml");

        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(o.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(o,file);
        } catch (JAXBException e) {
            logger.error("Problems with JAXB", e);
            e.printStackTrace();
        }
    }

    @Override
    public Object getObject(File file, Class c) throws JAXBException {
        return null;
    }

    @Override
    public void saveObject(File file, Object o) throws JAXBException {

    }

}