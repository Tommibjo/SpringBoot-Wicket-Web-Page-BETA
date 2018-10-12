/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.controlview;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author tommib
 */
public class DropMenu extends Panel {

    public DropMenu(String id) {
        super(id);

        add(new Link<Void>("index") {
            @Override
            public void onClick() {
                setResponsePage(Index.class);
            }
        });
        add(new Link<Void>("aboutpage") {
            @Override
            public void onClick() {
                // mainWindow.setTitle("About");
            }
        });
        add(new Link<Void>("filespage") {
            @Override
            public void onClick() {
                //  setResponsePage(FilesPage.class);
            }
        });
    }
}
