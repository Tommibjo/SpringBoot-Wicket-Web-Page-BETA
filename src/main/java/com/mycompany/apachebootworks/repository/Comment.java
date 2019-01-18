/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.repository;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 *
 * Model layer: Suorat tietokantayhteydet, ei busines logiikkaa.
 *
 * @author tommib
 */
@Entity
@Component
@Table(name = "messages")
public class Comment implements Serializable { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Integer id;
    private String name;
    private String message;
    private String postTime;

    public Comment() {

    }

    public Comment(String name, String message, String postTime) {
        this.name = name;
        this.message = message;
        this.postTime = postTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", name=" + name + ", comment=" + message + ", postTime=" + postTime + '}';
    }

}
