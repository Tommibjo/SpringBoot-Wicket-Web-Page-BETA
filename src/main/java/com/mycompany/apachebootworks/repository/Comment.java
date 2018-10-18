/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.repository;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * Model layer: Suorat tietokantayhteydet, ei busines logiikkaa.
 *
 * @author tommib
 */
@Entity
public class Comment extends AbstractPersistable<Long> implements Serializable { // Comment pojon pitää implementoida serializable rajapinta WICKET:in takia.

    @Id
    private Long id;
    private String name;
    private String comment;
    private String postTime;

    public Comment() {

    }

    public Comment(String name, String comment, String postTime) {
        this.name = name;
        this.comment = comment;
        this.postTime = postTime;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

}
