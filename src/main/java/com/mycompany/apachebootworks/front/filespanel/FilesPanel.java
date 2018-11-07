/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.filespanel;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.mycompany.apachebootworks.security.AuthenticatedApplication;
import com.mycompany.apachebootworks.security.AuthenticatedSession;
import org.apache.wicket.Application;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author tommib
 */
@AuthorizeInstantiation("SIGssNED_IN")
public class FilesPanel extends Panel {

    @Override
    protected void onConfigure() {
        super.onConfigure();
        System.out.println("Onconfigure!");
        WicketBootSecuredWebApplication app = (WicketBootSecuredWebApplication) Application.get();
        if (!AuthenticatedSession.get().isSignedIn()) {
            app.restartResponseAtSignInPage();
        }
    }

    public FilesPanel(String id) {
        super(id);
    }
}
