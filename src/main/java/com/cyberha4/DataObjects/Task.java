package com.cyberha4.DataObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by admin on 19.02.2017.
 */
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
    private int id;
    private User user;
    private int status_id;
    private int type_id;
    private String title;
    private String annotation;
    private String text;

    public Task(int id, User user_id, int status_id, int type_id, String title, String annotation, String text) {
        this.id = id;
        this.user = user_id;
        this.status_id = status_id;
        this.type_id = type_id;
        this.title = title;
        this.annotation = annotation;
        this.text = text;
    }

    public Task(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user_id) {
        this.user = user_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
