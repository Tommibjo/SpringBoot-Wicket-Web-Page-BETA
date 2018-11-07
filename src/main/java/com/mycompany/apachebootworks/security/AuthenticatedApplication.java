/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.security;

import com.giffing.wicket.spring.boot.context.security.AuthenticatedWebSessionConfig;
import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author tommib
 */
@Component
public class AuthenticatedApplication extends WicketBootSecuredWebApplication implements AuthenticatedWebSessionConfig{
    @Bean
    @Override
    public Class<? extends AbstractAuthenticatedWebSession> getAuthenticatedWebSessionClass() {
        return AuthenticatedSession.class;
    }
}
