/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front;

import com.mycompany.apachebootworks.repository.Comment;
import com.mycompany.apachebootworks.service.CommentService;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author tommib
 */
public class CommentPanel extends Panel {

    @SpringBean // Wicket ei tunne "@Autowired" annonaatiota. Tämä ajaa saman.
    private CommentService commentService;

    public CommentPanel(String id) {
        super(id);
        this.commentService.addComment("nimi", "kommentti");
        List allCommentsList = this.commentService.getAllComments(); //Hae CommentServicestä kaikki kommentit
        add(new ListView<Comment>("commentview", allCommentsList) { // Tehdään uusi ListView<Comment> lista ja lisätään Lista siihen (Wicket ID:llä "commentview"
            @Override   // "Yliajetaan" ListViewin oma populateItem
            public void populateItem(final ListItem<Comment> commentObjects){ // Tehdään populateItemillä vielä yksi oma lista.
                final Comment commentObject = commentObjects.getModelObject(); 
                commentObjects.add(new Label("name", commentObject.getName()));
                commentObjects.add(new Label("comment", commentObject.getComment()));
            }
        });
    }
}
