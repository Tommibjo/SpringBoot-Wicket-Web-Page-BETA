/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.homepanel;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.mycompany.apachebootworks.front.commentpanel.CommentPanel;
import com.mycompany.apachebootworks.security.AuthenticatedSession;
import org.apache.wicket.Application;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author Tommi
 */
public class HomePanel extends Panel {

    private CommentPanel commentPanel;
    public HomePanel(String id) {
        super(id);
        this.commentPanel = new CommentPanel("comment");
        System.out.println("Homepanel constructor");
        add(this.commentPanel);        
    }
}
