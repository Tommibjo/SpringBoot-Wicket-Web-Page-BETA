/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.aboutpanel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author Tommi
 */
public class AboutPanel extends Panel {

    private Label id;
    private Label feedback;
    private Label locale;
    private Label markupid;
  //  private Label page;
    private Label relativePath;
    private Label parent;
    private Label path;

    public AboutPanel(String id) {
        super(id);
        System.out.println("Aboutpanel constructor");
        this.id = new Label("id", this.getId());
        this.feedback = new Label("fbmessage", this.getFeedbackMessages());
        this.locale = new Label("locale", this.getLocale());
        this.markupid = new Label("markupid", this.getMarkupId());
   //     this.page = new Label("page", this.getPage());
        this.relativePath = new Label("relativepath", this.getPageRelativePath());
        this.parent = new Label("parent", this.getParent());
        this.path = new Label("path", this.getPath());
        add(this.id);
        add(this.feedback);
        add(this.locale);
        add(this.markupid);
    //    add(this.page);
        add(this.relativePath);
        add(this.parent);
        add(this.path);
    }

}
