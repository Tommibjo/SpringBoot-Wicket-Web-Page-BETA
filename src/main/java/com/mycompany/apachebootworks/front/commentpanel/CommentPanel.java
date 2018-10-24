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
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author tommib
 */
public class CommentPanel extends Panel {

    @SpringBean
    private CommentService commentService;
    @SpringBean
    private CommentPOJO commentpojo;

    private List commentList;
    private Form commentForm;
    private TextArea<String> comment;
    private TextField<String> name;

    public CommentPanel(String id) {
        super(id);

        //===========START========
        // Comment form
        //========================
        this.comment = new TextArea<String>("commentfield", new PropertyModel<>(commentpojo, "comment"));
        this.name = new TextField<String>("namefield", new PropertyModel<>(commentpojo, "name"));
        this.commentForm = new CommentForm("commentform");
        this.commentForm.setOutputMarkupId(true);
        this.commentForm.add(new AjaxSubmitLink("addcomment") {
            @Override
            public void onSubmit(AjaxRequestTarget target) {
                System.out.println(commentpojo.getName() + ":" + commentpojo.getComment());
                commentService.addComment(commentpojo.getName(), commentpojo.getComment());
            }
        });
        this.commentForm.add(this.comment);
        this.commentForm.add(this.name);
        add(this.commentForm);
        //===========END==========
        // Comment form
        //========================

        //===========START========
        // Comment list
        //========================
        this.commentList = this.commentService.getAllComments();
        add(new ListView<Comment>("commentview", commentList) {
            @Override
            public void populateItem(final ListItem<Comment> item) {
                final Comment comment = item.getModelObject();
                item.add(new Label("name", comment.getName()));
                item.add(new Label("comment", comment.getComment()));
            }
        });
        //===========END==========
        // Comment list
        //========================
    }
}
