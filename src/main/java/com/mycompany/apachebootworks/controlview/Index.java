/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.controlview;


import org.apache.wicket.markup.html.WebPage;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.basic.Label;
/**
 * Controller (.html on view): ohjaa sivunselauspyynnöt ja käyttää serviseä.
 * @author tommib
 */
@WicketHomePage
public class Index extends WebPage{

    public Index(){
        add(new Label("title", "Juurivuohi Works"));
        add(new DropMenu("dropmenu"));
        add(new MainWindow("window"));
    }
}   
