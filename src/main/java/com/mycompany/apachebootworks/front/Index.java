/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front;

import com.mycompany.apachebootworks.front.homepanel.HomePanel;
import com.mycompany.apachebootworks.front.filepanel.FilePanel;
import com.mycompany.apachebootworks.front.commentpanel.CommentPanel;
import com.mycompany.apachebootworks.front.aboutpanel.AboutPanel;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;

/*
 * Main page
 */
@WicketHomePage
public class Index extends WebPage {

    private Component homePanel;
    private Component aboutPanel;
    private Component filePanel;
    private final Component commentPanel;

    public Index() {
        
        // Add panels to main view (String in constructor is HTML wicket:id)
        this.homePanel = new HomePanel("home"); 
        this.aboutPanel = new AboutPanel("about"); 
        this.filePanel = new FilePanel("files");
        this.commentPanel = new CommentPanel("comment"); 
        
        // Hide a few panels
        this.filePanel.setVisible(false);
        this.aboutPanel.setVisible(false);
        
        // Make panels modifiable by ajax
        this.homePanel.setOutputMarkupPlaceholderTag(true); 
        this.aboutPanel.setOutputMarkupPlaceholderTag(true);
        this.filePanel.setOutputMarkupPlaceholderTag(true); 
 
        // Add panels 
        add(this.homePanel); 
        add(this.aboutPanel); 
        add(this.filePanel); 
        add(this.commentPanel);
        add(new AjaxLink<Void>("homepage") { // AJAXLink and its HTML id.
            @Override
            public void onClick(AjaxRequestTarget art) { // upon clicking HTML id, do this.

                homePanel.setVisible(true);
                aboutPanel.setVisible(false);
                filePanel.setVisible(false);
                art.add(homePanel);
                art.add(aboutPanel);
                art.add(filePanel);
            }
        });
        add(new AjaxLink<Void>("aboutpage") {
            @Override
            public void onClick(AjaxRequestTarget art) {

                homePanel.setVisible(false);
                aboutPanel.setVisible(true);
                filePanel.setVisible(false);
                art.add(homePanel);
                art.add(aboutPanel);
                art.add(filePanel);
            }
        });
        add(new AjaxLink<Void>("filespage") {
            @Override
            public void onClick(AjaxRequestTarget art) {

                homePanel.setVisible(false);
                aboutPanel.setVisible(false);
                filePanel.setVisible(true);
                art.add(homePanel);
                art.add(aboutPanel);
                art.add(filePanel);
            }
        });

    }
}
