package Jaxb;

import javafx.application.Application;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by admin on 19.02.2017.
 */

public class JaxbParser implements Parser {
    public static final String pathToSrialize = "Xml";
    public static final String locationModels = "DataObjects";

    @Deprecated
    public Object getObject(File file, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(file);

        return object;
    }

    public Object getObject(Class c) throws JAXBException {
        File file = new File(pathToSrialize+"/"+c.getCanonicalName()+".xml");

        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(file);

        return object;
    }
@Deprecated
    public void saveObject(File file, Object o) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(o,file);
    }

    public void saveObject(Object o) throws JAXBException {
        File file = new File(pathToSrialize+"/"+o.getClass().getCanonicalName()+".xml");

        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(o,file);
    }
}