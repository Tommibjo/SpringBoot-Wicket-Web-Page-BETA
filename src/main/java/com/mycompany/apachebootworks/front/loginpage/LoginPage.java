/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.loginpage;

import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
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
public class LoginPage extends WebPage {

    @SpringBean
    private UserPOJO userpojo;
    
    private TextField username;
    private PasswordTextField password;
    private Form loginForm;
    
    public LoginPage(){
        this.username = new TextField("nimi", new PropertyModel(userpojo, "username"));
        this.password = new PasswordTextField("salasana", new PropertyModel(userpojo, "password"));
        this.loginForm = new Form("login"){
          @Override
          public void onSubmit(){
              System.out.println("Submit overide!: " + userpojo.getUsername() + " : " + userpojo.getPassword());
          }
        };
        add(this.username);
        add(this.password);
    }
}
