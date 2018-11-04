/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.login;

import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;
import org.springframework.stereotype.Component;

/**
 *
 * @author tommib
 */

public class Authentication extends AuthenticatedWebSession{

    public Authentication(Request request) {
        super(request);
    }

    @Override
    protected boolean authenticate(String username, String password) {
        System.out.println("Triggeröityykö authorisointi??");
        return "testi".equals(username) && "testi".equals(password);
    }

    // "Can be ignored untill we discuss role-based authorization" - 21 Security with wicket 6.x
    // AuthenticatedWebSession inherits this from it's own parent (AbstractAuthenticatedWebSession)
    @Override
    public Roles getRoles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
