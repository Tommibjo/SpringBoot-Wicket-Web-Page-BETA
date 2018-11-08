/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front;

import com.mycompany.apachebootworks.front.homepanel.HomePanel;
//import com.mycompany.apachebootworks.front.commentpanel.CommentPanel;
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
    
    private HomePanel homePanel;
 //   private CommentPanel commentPanel;
    private AboutPanel aboutPanel;
  //  private FilesPanel filesPanel;
    
    private WebMarkupContainer panelContainer;

    public Index() {
        this.panelContainer = new WebMarkupContainer("panelContainer");
        this.homePanel = new HomePanel("panel");
        this.aboutPanel = new AboutPanel("panel");
    //    this.filesPanel = new FilesPanel("panel");
        
  
        this.panelContainer.add(this.homePanel);
   //     this.panelContainer.add(this.commentPanel);
        add(this.panelContainer.setOutputMarkupId(true));

        add(new AjaxLink<Void>("homepage") {
            @Override
            public void onClick(AjaxRequestTarget art) {
                art.add(panelContainer.replace(homePanel)); 
            }
        });

        add(new AjaxLink<Void>("aboutpage") {
            @Override
            public void onClick(AjaxRequestTarget art) {
                art.add(panelContainer.replace(aboutPanel)); 

            }
        });

        add(new AjaxLink<Void>("filespage") {
            @Override
            public void onClick(AjaxRequestTarget art) {
                FilesPanel filesPanel = new FilesPanel("panel");
                art.add(panelContainer.replace(filesPanel));
            }
        });
    }
}
