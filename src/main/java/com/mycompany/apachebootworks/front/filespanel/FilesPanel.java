/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.filespanel;

import org.apache.wicket.Application;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.panel.Panel;
//import org.wicketstuff.annotation.mount.MountPath;

/**
 *
 * @author tommib
 */
//@AuthorizeInstantiation("ADMIN")
public class FilesPanel extends Panel {
    
    // Tämän ansiosta wicket heittää heti suoraan @WicketSignInPage annotaatiolla merkitylle sivulle
    @Override
    protected void onConfigure(){
        super.onConfigure();
        AuthenticatedWebApplication app = (AuthenticatedWebApplication)Application.get();
        if(!AuthenticatedWebSession.get().isSignedIn()){
            app.restartResponseAtSignInPage();
        }
        
    }

    public FilesPanel(String id) {
        super(id);
    }
}
