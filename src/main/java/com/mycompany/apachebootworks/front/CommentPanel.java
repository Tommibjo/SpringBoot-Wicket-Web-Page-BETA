/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front;

import com.mycompany.apachebootworks.repository.CommentRepository;
import com.mycompany.apachebootworks.service.CommentService;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tommib
 */
public class CommentPanel extends Panel {

    @Autowired
    private CommentService commentService;

    public CommentPanel(String id) {
        super(id);
        List allCommentsList = commentService.getAllComments();
        ListView allCommentsView = new ListView("commentview", allCommentsList) {
            @Override
            protected void populateItem(ListItem li) {
                li.add(new Label("comment", li.getModel()));
            }
        };
        add(allCommentsView);
    }
}
