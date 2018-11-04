/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front;

import com.mycompany.apachebootworks.front.homepanel.HomePanel;
import com.mycompany.apachebootworks.front.commentpanel.CommentPanel;
import com.mycompany.apachebootworks.front.aboutpanel.AboutPanel;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.mycompany.apachebootworks.front.filespanel.FilesPanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;

/*
 * Main component
 */
@WicketHomePage
public class Index extends WebPage {

    private WebMarkupContainer panelContainer;

    public Index() {
        this.panelContainer = new WebMarkupContainer("panels");
        
        this.panelContainer.add(new HomePanel("home").setOutputMarkupId(true));
        this.panelContainer.add(new CommentPanel("comment").setOutputMarkupId(true));
        this.panelContainer.add(new AboutPanel("about").setOutputMarkupId(true).setVisible(false));
        this.panelContainer.add(new FilesPanel("files").setOutputMarkupId(true).setVisible(false));

        this.panelContainer.setOutputMarkupId(true);
        add(this.panelContainer);

        add(new AjaxLink<Void>("homepage") {
            @Override
            public void onClick(AjaxRequestTarget art) {

                art.add(panelContainer.get("home").setVisible(true));
                art.add(panelContainer.get("comment").setVisible(true));
                art.add(panelContainer.get("about").setVisible(false));
                art.add(panelContainer.get("files").setVisible(false));

            }
        });

        add(new AjaxLink<Void>("aboutpage") {
            @Override
            public void onClick(AjaxRequestTarget art) {

                art.add(panelContainer.get("home").setVisible(false));
                art.add(panelContainer.get("comment").setVisible(false));
                art.add(panelContainer.get("about").setVisible(true));
                art.add(panelContainer.get("files").setVisible(false));

            }
        });

        add(new AjaxLink<Void>("filespage") {
            @Override
            public void onClick(AjaxRequestTarget art) {

                art.add(panelContainer.get("home").setVisible(false));
                art.add(panelContainer.get("comment").setVisible(false));
                art.add(panelContainer.get("about").setVisible(false));
                art.add(panelContainer.get("files").setVisible(true));
            }
        });
    }
}
