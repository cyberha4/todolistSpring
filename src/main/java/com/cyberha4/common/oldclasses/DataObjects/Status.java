package com.cyberha4.common.oldclasses.DataObjects;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by admin on 20.02.2017.
 */
@XmlRootElement(name = "status")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name= "statuses")
public class Status {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name= "status")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String name) {
        this.status = name;
    }


    public Status() {
    }

    public Status(int id, String status) {
        this.id = id;
        this.status = status;
    }
}
