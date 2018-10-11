/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.controlview;

import org.apache.wicket.markup.html.WebPage;

/**
 *
 * @author tommib
 */
public class FilesPage extends WebPage {

    public FilesPage() {
        add(new DropMenu("dropmenu"));
    }
}
