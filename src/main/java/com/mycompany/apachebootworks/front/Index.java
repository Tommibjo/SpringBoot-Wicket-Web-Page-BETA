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

    private Component homePanel = new HomePanel("home");
    private Component aboutPanel = new AboutPanel("about");

    public Index() {
        add(homePanel);
        add(aboutPanel);
        homePanel.setOutputMarkupId(true);
        aboutPanel.setOutputMarkupId(true);
        add(new AjaxLink<Void>("click") {
            @Override
            public void onClick(AjaxRequestTarget art) {
                homePanel.setVisible(false);
                aboutPanel.setVisible(true);
            }
        });
    }
}
