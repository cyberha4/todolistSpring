package com.cyberha4.common.oldclasses.Jaxb;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Created by admin on 19.02.2017.
 */
public interface Parser {
    Object getObject(File file, Class c) throws JAXBException;
    Object getObject(Class c);
    void saveObject(File file, Object o) throws JAXBException;
    void saveObject(Object o);
}
