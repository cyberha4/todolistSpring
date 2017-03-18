package com.cyberha4.common.oldclasses.DataObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by admin on 20.02.2017.
 */
@XmlRootElement(name = "type")
@XmlAccessorType(XmlAccessType.FIELD)

public class Type {
    private int id;
    private String type;

    public Type() {
    }

    public Type(int id, String type) {

        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
