package com.cyberha4.models.entity;

import com.cyberha4.models.pojo.User;

import javax.persistence.*;

/**
 * Created by admin on 18.03.2017.
 */
@Entity
@Table(name="tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    @Column(name = "status_id")
    private Integer statusId;
    @Column(name = "type_id")
    private Integer typeId;
    @Column(name = "title")
    private String title = "";
    @Column(name = "annotation")
    private String annotation = "";
    @Column(name = "text")
    private String text = "";
    @Column(name = "created")
    private String create;
    @Column
    private String finished;

    @Version
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

//    public int getFinishedTime() {
//        return finishedTime;
//    }
//
//    public void setFinishedTime(int finishedTime) {
//        this.finishedTime = finishedTime;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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

//    public int getCreatedTime() {
//        return createdTime;
//    }
//
//    public void setCreatedTime(int createdTime) {
//        this.createdTime = createdTime;
//    }



    public TaskEntity() {
    }

    public TaskEntity(UserEntity user, int statusId, int typeId, String title, String annotation, String text, int createdTime) {
        this.id = id;
        this.user = user;
        this.statusId = statusId;
        this.typeId = typeId;
        this.title = title;
        this.annotation = annotation;
        this.text = text;
//        this.createdTime = createdTime;
    }

    public TaskEntity(UserEntity user, int statusId, int typeId, String title, String annotation, String text,
                      String create, String finished) {
        this.id = id;
        this.user = user;
        this.statusId = statusId;
        this.typeId = typeId;
        this.title = title;
        this.annotation = annotation;
        this.text = text;
        this.create = create;
        this.finished = finished;
    }
    public TaskEntity(int id, UserEntity user, int statusId, int typeId, String title, String annotation, String text,
                      String create, String finished) {
        this.id = id;
        this.user = user;
        this.statusId = statusId;
        this.typeId = typeId;
        this.title = title;
        this.annotation = annotation;
        this.text = text;
        this.create = create;
        this.finished = finished;
    }
}
