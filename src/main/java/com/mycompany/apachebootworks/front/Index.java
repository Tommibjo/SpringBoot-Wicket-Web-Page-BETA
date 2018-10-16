/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;

/**
 *
 * !!! EHDOTUS: LISÄÄ TÄMÄ WICKET FRONTTI JA TARVITTAVAT KIRJASTOT VANHAAN
 * PROJEKTIIN.
 */
@WicketHomePage
public class Index extends WebPage {

    private Component homePanel = new HomePanel("home"); // "home" string within HomePanel constructor is HTML TAG 
    private Component aboutPanel = new AboutPanel("about"); // "about" string within AboutPAnel constructor is HTML TAG 
    private Component filePanel = new FilePanel("files"); // "files" string within FilePanel constructor is HTML TAG 
   // private Component commentPanel = new CommentPanel("comment"); // "comment" string withing CommentPanel constructor is HTML tag // FOR SOME REASON COMMENTPANEL CAUSES CONSTRUCTOR ERROR @ INDEX.CLASS.

    public Index() {

        add(homePanel); // Add homePanel to be used in HTML (via constructors id)
        add(aboutPanel); // Add aboutPanel to be used in HTML (via constructors id)
        aboutPanel.setVisible(false); // hide aboutPanel
        add(filePanel); // add filePanel to be used in HTML (via constructors id)
        filePanel.setVisible(false); // hide filePanel
    //    add(commentPanel); // FOR SOME REASON COMMENTPANEL CAUSES CONSTRUCTOR ERROR @ INDEX.CLASS.

        homePanel.setOutputMarkupPlaceholderTag(true); // make homePanel modifiable via AJAX
        aboutPanel.setOutputMarkupPlaceholderTag(true); // make aboutPanel modifiable via AJAX
        filePanel.setOutputMarkupPlaceholderTag(true); // make filePanel modifiable via AJAX

        add(new AjaxLink<Void>("click") { // AJAXLink and its HTML id.
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
        add(new AjaxLink<Void>("click2") {
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
        add(new AjaxLink<Void>("click3") {
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
