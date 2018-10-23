/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.commentpanel;

import com.mycompany.apachebootworks.front.commentform.CommentForm;
import com.mycompany.apachebootworks.repository.Comment;
import com.mycompany.apachebootworks.service.CommentService;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
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
    private List commentList;
    private Form commentForm;

    public CommentPanel(String id) {
        super(id);
        this.commentService.addComment("nimi", "kommentti");
        this.commentList = this.commentService.getAllComments(); //Hae CommentServicestä kaikki kommentit
        this.commentForm = new CommentForm("commentinput");

        add(this.commentForm);
        add(new ListView<Comment>("commentview", commentList) { // Tehdään uusi ListView<Comment> lista ja lisätään Lista siihen (Wicket ID:llä "commentview"
            @Override   // "Yliajetaan" ListViewin oma populateItem
            public void populateItem(final ListItem<Comment> item) { // Tehdään populateItemillä vielä yksi oma lista.
                final Comment comment = item.getModelObject();
                item.add(new Label("name", comment.getName()));
                item.add(new Label("comment", comment.getComment()));
            }
        });
    }
}
