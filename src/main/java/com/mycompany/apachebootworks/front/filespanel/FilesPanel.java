/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.filespanel;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author tommib
 */
@AuthorizeInstantiation("SIGNED_IN")
public class FilesPanel extends Panel {

    public FilesPanel(String id) {
        super(id);
        System.out.println("Filespanel constructor");
    }
}
