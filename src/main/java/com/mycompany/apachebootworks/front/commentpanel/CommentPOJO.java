/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.commentpanel;

import org.springframework.stereotype.Component;

/**
 * BRG
 *
 * @author tommib
 */
// POJO for CommentPanel
@Component
public class CommentPOJO {

    private String name;
    private String comment;

    public CommentPOJO() {

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
}
