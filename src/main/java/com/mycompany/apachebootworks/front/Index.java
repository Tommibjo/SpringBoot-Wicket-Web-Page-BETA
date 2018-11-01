/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front;

import com.mycompany.apachebootworks.front.homepanel.HomePanel;
import com.mycompany.apachebootworks.front.commentpanel.CommentPanel;
import com.mycompany.apachebootworks.front.aboutpanel.AboutPanel;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.mycompany.apachebootworks.front.filespanel.FilesPanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;
/*
 * Main component
 */
@WicketHomePage
public class Index extends WebPage {



    // Alikomponetit
    private Panel homePanel;
    private Panel commentPanel;
    private Panel aboutPanel;
    private Panel filesPanel;

    public Index() {
       
        // Alikomponentit
        this.homePanel = new HomePanel("home");
        this.commentPanel = new CommentPanel("comment");
        this.aboutPanel = new AboutPanel("about");
        this.filesPanel = new FilesPanel("files");

        // Piilotetaan muut, paitsi homePanel ja commentPanel
        this.aboutPanel.setVisible(false);
        this.filesPanel.setVisible(false);

        // Paneelit ajax muokattaviksi
        this.homePanel.setOutputMarkupPlaceholderTag(true);
        this.commentPanel.setOutputMarkupPlaceholderTag(true);
        this.aboutPanel.setOutputMarkupPlaceholderTag(true);
        this.filesPanel.setOutputMarkupPlaceholderTag(true);

        // Lisätään panelit Markupiin
        add(this.homePanel);
        add(this.commentPanel);
        add(this.aboutPanel);
        add(this.filesPanel);
        
        /*
        *  Sivun vaihdot with AjaxLink
         */
        add(new AjaxLink<Void>("homepage") {
            @Override
            public void onClick(AjaxRequestTarget art) {

                homePanel.setVisible(true);
                commentPanel.setVisible(true);
                aboutPanel.setVisible(false);
                filesPanel.setVisible(false);
                art.add(homePanel);
                art.add(commentPanel);
                art.add(aboutPanel);
                art.add(filesPanel);

            }
        });

        add(new AjaxLink<Void>("aboutpage") {
            @Override
            public void onClick(AjaxRequestTarget art) {

                homePanel.setVisible(false);
                commentPanel.setVisible(false);
                aboutPanel.setVisible(true);
                filesPanel.setVisible(false);
                art.add(homePanel);
                art.add(commentPanel);
                art.add(aboutPanel);
                art.add(filesPanel);

            }
        });

        add(new AjaxLink<Void>("filespage") {
            @Override
            public void onClick(AjaxRequestTarget art) {

                homePanel.setVisible(false);
                commentPanel.setVisible(false);
                aboutPanel.setVisible(false);
                filesPanel.setVisible(true);
                art.add(homePanel);
                art.add(commentPanel);
                art.add(aboutPanel);
                art.add(filesPanel);
            }
        });
    }
}
