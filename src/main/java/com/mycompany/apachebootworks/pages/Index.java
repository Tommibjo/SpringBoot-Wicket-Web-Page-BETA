/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.pages;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
/**
 *
 * @author tommib
 */
@WicketHomePage
public class Index extends WebPage{
    
    public Index(){
        add(new Label("hello", "Hello World!"));
    }
}   
