/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front;

import com.mycompany.apachebootworks.front.homepanel.HomePanel;
import com.mycompany.apachebootworks.front.aboutpanel.AboutPanel;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.mycompany.apachebootworks.front.filespanel.FilesPanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import com.mycompany.apachebootworks.front.commentpanel.CommentPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/*
 * Main component
 */
@WicketHomePage
public class Index extends WebPage {
    
    private HomePanel homePanel;
    private AboutPanel aboutPanel;
    private CommentPanel commentPanel;
    private WebMarkupContainer panelContainer;
    
    public Index(PageParameters p) {
        
        this.panelContainer = new WebMarkupContainer("panelContainer");
        this.homePanel = new HomePanel("panel");
        this.aboutPanel = new AboutPanel("panel");
        this.commentPanel = new CommentPanel("comment");
        
        // Jos PageParametri P ei ole tyhjä, on käyttäjä kirjautunut LoginPagen kautta Files paneeliin, eli tällöin lyödään näkymään Files paneeli.
        // Muussa tapauksessa, kun sivu ladataan, näytetään aina ensimmäiseksi Home paneeli
        if (p.isEmpty()) {
            this.panelContainer.add(this.homePanel);            
        } else {
            this.panelContainer.add(new FilesPanel("panel"));
        }
        

        add(this.commentPanel);
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
