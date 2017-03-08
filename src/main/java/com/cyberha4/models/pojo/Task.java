package com.cyberha4.models.pojo;

/**
 * Created by admin on 25.02.2017.
 */
public class Task {
    private int id;
    private User user;
    private int statusId;
    private int typeId;
    private String title = "";
    private String annotation = "";
    private String text = "";
    private int createdTime;

    public int getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(int finishedTime) {
        this.finishedTime = finishedTime;
    }

    private int finishedTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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

    public int getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(int createdTime) {
        this.createdTime = createdTime;
    }



    public Task() {
    }

    public Task(int id, User user, int statusId, int typeId, String title, String annotation, String text, int createdTime) {
        this.id = id;
        this.user = user;
        this.statusId = statusId;
        this.typeId = typeId;
        this.title = title;
        this.annotation = annotation;
        this.text = text;
        this.createdTime = createdTime;
    }
}
