/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.controlview;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 *
 * @author Tommi
 */
public class MainWindow extends Panel {

    /*
    * KONSTRUKTORI
     */
    public MainWindow(String id) {
        super(id); // Kutsutaan ylemmän luokan konstruktoria "window" stringillä. (Index.java -> add(new MainWindow("window"));)

        /*
        * AJAX MATSKUA
         */
        //===========
        Model<Integer> model; // Luodaan uusi wicket model. Wicket model ylläpitää komponentin arvoa I.E. -> add(new Label("message", "Hello World!")); -> ("name", new Model("Hello World!));. Ensimmäinen tapa on helppokäyttöisyyttä varten tehty.
        model = new Model<Integer>() {
            private Integer title = 0;

            @Override
            public Integer getObject() {
                return title++;
            }
        };
        //===========
        final Label label = new Label("title", model); // Luodaan label niminen olio, jota alempana käsitellään.
        label.setOutputMarkupId(true); // Tehdään label oliosta AJAX:illa muotoiltava
       //===========
        add(new AjaxLink("link") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                if (target != null) {
                    target.add(label);
                }
            }
        });
        /*
        * AJAX MATSKUA
         */

        add(label); // Lisätään Label HTML:län ("Mark up filun") käyttöön.
    }
    /*
    * END OF KONSTRUKTORI
     */
}
