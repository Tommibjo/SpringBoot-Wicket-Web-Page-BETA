/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.commentpanel;

import com.mycompany.apachebootworks.repository.Comment;
import com.mycompany.apachebootworks.service.CommentService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Comment area panel
 *
 * @author tommib
 */
public class CommentPanel extends Panel {

    // "@Autowiring"
    @SpringBean
    private CommentService commentService;
    @SpringBean
    private CommentPOJO commentpojo;

    private IModel commentList;
    private Form commentForm;
    private TextArea<String> comment;
    private TextField<String> name;
    private WebMarkupContainer listContainer;

    public CommentPanel(String id) {
        super(id);
        
        /*
         *Kommenttien listaus
         */
        this.commentList = new LoadableDetachableModel() {
            @Override
            protected Object load() {
                return commentService.getAllComments();
            }
        };
        this.comment = new TextArea<>("commentfield", new PropertyModel<>(commentpojo, "comment"));
        this.name = new TextField<>("namefield", new PropertyModel<>(commentpojo, "name"));
        this.comment.setOutputMarkupId(true);
        this.name.setOutputMarkupId(true);
        this.listContainer = new WebMarkupContainer("theContainer");
        this.listContainer.add(new ListView<Comment>("commentview", this.commentList) {
            @Override
            public void populateItem(final ListItem<Comment> item) {
                final Comment comment = item.getModelObject();
                item.add(new Label("name", comment.getName()));
                item.add(new Label("comment", comment.getComment()));
                System.out.println(comment.toString());
            }
        });
        this.listContainer.setOutputMarkupId(true); 
        add(this.listContainer);

        /*
         * Kommenttien rekisteröinti
         */
        this.commentForm = new Form("commentform");
        this.commentForm.add(new AjaxSubmitLink("addcomment") {
            @Override
            public void onSubmit(AjaxRequestTarget target) {
                commentService.addComment(commentpojo.getName(), commentpojo.getComment());
                target.add(listContainer);
                // Tyhjentää tekstikentän
                comment.setModelObject(null);
                target.add(comment);
                // Tyhjentää nimikentän
                name.setModelObject(null);
                target.add(name);
            }

        });
        this.commentForm.add(this.comment);
        this.commentForm.add(this.name);
        add(this.commentForm);
    }
}
