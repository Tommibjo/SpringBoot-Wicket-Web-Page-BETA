/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.controlview;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.WebMarkupContainer;

/**
 *
 * @author tommib
 */
public class DropMenu extends Panel {

    WebMarkupContainer css = new WebMarkupContainer("DropMenuCSS");

    public DropMenu(String id) {
        super(id);
        add(css);
        add(new Link<Void>("index") {
            @Override
            public void onClick() {
                setResponsePage(Index.class);
            }
        });
        add(new Link<Void>("aboutpage") {
            @Override
            public void onClick() {
                setResponsePage(AboutPage.class);
            }
        });
        add(new Link<Void>("filespage") {
            @Override
            public void onClick() {
                setResponsePage(FilesPage.class);
            }
        });
    }
}
