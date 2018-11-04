/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.login;

import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author tommib Spring Boot securityllä on kyllä on login formi... Sitä olisi
 * kiva käyttää AJAX:in kanssa. Kun Spring security formi OK, niin näytä
 * ajaxilla uusi Label, jossa filut.
 *
 */
@WicketSignInPage
public class LoginPanel extends WebPage {

    @SpringBean
    private UserPOJO userpojo;

    @Override
    protected void onInitialize() {
        super.onInitialize();
        System.out.println("LoginPanel onInitialize aktivoitu!-------");
        PasswordTextField password = new PasswordTextField("salasana", new PropertyModel<>(userpojo, "password"));
        TextField name = new TextField("nimi", new PropertyModel<>(userpojo, "username"));
        StatelessForm login = new StatelessForm("login") {
            @Override
            protected void onSubmit() {
                System.out.println("<---- FORM ONSUBMIT() AKTIVOITU ------>");
                boolean auth = AuthenticatedWebSession.get().signIn(userpojo.getUsername(), userpojo.getPassword());
                System.out.println(name + " : " + password);
                if (auth) {
                    continueToOriginalDestination();
                    System.out.println("<--- TUNNUKSET OIKEIN - JATKETAAN ALKUPERÄiSEEN OSOITTEESEEN --->");
                } else {
                    System.out.println("Väärä salasana tjtnsp!");
                }
            }
        };
        login.setDefaultModel(new CompoundPropertyModel(this));
        login.add(name);
        login.add(password);
        add(login);
    }
}
