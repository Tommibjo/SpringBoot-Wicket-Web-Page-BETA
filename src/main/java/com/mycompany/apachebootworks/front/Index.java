/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front;

import org.apache.wicket.markup.html.WebPage;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import javax.annotation.PostConstruct;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;

/**
 * 
 *  !!! EHDOTUS: LISÄÄ TÄMÄ WICKET FRONTTI JA TARVITTAVAT KIRJASTOT VANHAAN PROJEKTIIN.
 */
@WicketHomePage
public class Index extends WebPage {

    public Index() {
        // Alustetaan child komponentti 
        Label title = new Label("title", "Home");
        add(title); // Lisätään title markup(Html) käyttöön.
        title.setOutputMarkupId(true); // Lisätään title Ajaxilla muokattavaksi
        // Alustetaan title komponentti

        //****************************
        add(new AjaxLink<Void>("indexpage") {
            @Override
            public void onClick(AjaxRequestTarget art) {
                title.setDefaultModelObject("Home");
                art.add(title);
            }
        });
        add(new AjaxLink<Void>("aboutpage") {
            @Override
            public void onClick(AjaxRequestTarget art) {
                title.setDefaultModelObject("About");
                art.add(title);
            }
        });
        add(new AjaxLink<Void>("filespage") {
            @Override
            public void onClick(AjaxRequestTarget art) {
                title.setDefaultModelObject("Files");
                art.add(title);
            }
        });
        //****************************
    }
}
