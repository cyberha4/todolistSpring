package com.cyberha4.DataObjects;

import javax.xml.bind.annotation.*;

/**
 * Created by admin on 19.02.2017.
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    //@XmlAttribute(name = "id")
    private int id;
    private String name;

    public User(){

    }


    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
