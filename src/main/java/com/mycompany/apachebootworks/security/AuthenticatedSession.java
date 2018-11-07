/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.security;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

/**
 *
 * @author tommib
 */

public class AuthenticatedSession extends AuthenticatedWebSession {

    public AuthenticatedSession(Request request) {
        super(request);
    } 
    
    @Override
    protected boolean authenticate(String username, String password) {
        return false;
    }
    
    @Override
    public Roles getRoles() {
        Roles resultRoles = new Roles();
        resultRoles.add("SIGNED_IN");
        return resultRoles;
    }
}
