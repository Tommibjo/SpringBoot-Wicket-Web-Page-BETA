/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.loginpage;

import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;
import com.mycompany.apachebootworks.front.Index;
import com.mycompany.apachebootworks.front.filespanel.FilesPanel;
import com.mycompany.apachebootworks.security.AuthenticatedSession;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author tommib Spring Boot securityllä on kyllä on login formi... Sitä olisi
 * kiva käyttää AJAX:in kanssa. Kun Spring security formi OK, niin näytä
 * ajaxilla uusi Label, jossa filut.
 *
 */
@WicketSignInPage
public class LoginPage extends WebPage {

    @SpringBean
    private UserPOJO userpojo;

    private TextField username;
    private PasswordTextField password;
    private Form loginForm;
    private PageParameters params;

    public LoginPage() {

        this.username = new TextField("nimi", new PropertyModel(userpojo, "username"));
        this.password = new PasswordTextField("salasana", new PropertyModel(userpojo, "password"));
        this.params = new PageParameters();
        this.loginForm = new Form("login") {
            @Override
            public void onSubmit() {
                System.out.println("onSubmit(): " + userpojo.getUsername() + " : " + userpojo.getPassword());
                if (AuthenticatedSession.get().signIn(userpojo.getUsername(), userpojo.getPassword()) == true) {
                    params.add("panel", "loggedin");
                    setResponsePage(Index.class, params);
                }
            }
        };
        this.loginForm.add(this.username);
        this.loginForm.add(this.password);
        add(this.loginForm);

        add(new AjaxLink<Void>("back") {
            @Override
            public void onClick(AjaxRequestTarget art) {
                setResponsePage(Index.class);
            }
        });
    }
}
