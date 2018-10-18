/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.service;

import com.mycompany.apachebootworks.repository.Comment;
import com.mycompany.apachebootworks.repository.CommentRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service: Käyttää model layeria. (Sisältää business logiikan)
 * controlview kansion .java tiedostot käyttävät tätä serviseä.
 * @author tommib
 */
@Service
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;
    
    public CommentService(){
        System.out.println("Commentservice konstruktori laukaistu");
    }
    
    public List getAllComments(){
        return this.commentRepository.findAll();
    }
    
    public void addComment(String name, String comment){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date date = new Date();        
        commentRepository.saveAndFlush(new Comment(name, comment, dateFormat.format(date)));
    }   
    
}
