package Jaxb;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Created by admin on 19.02.2017.
 */
public interface Parser {
    Object getObject(File file, Class c) throws JAXBException;
    Object getObject(Class c) throws JAXBException;
    void saveObject(File file, Object o) throws JAXBException;
    void saveObject(Object o) throws JAXBException;
}
