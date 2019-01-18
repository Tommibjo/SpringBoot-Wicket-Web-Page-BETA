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
 * Service: Käyttää model layeria. (Sisältää business logiikan) controlview
 * kansion .java tiedostot käyttävät tätä serviseä.
 *
 * @author tommib
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentService() {
        System.out.println("Commentservice konstruktori laukaistu");
    }

    public List<Comment> getAllComments() {
        // PELKKÄ ALLA OLEVAN KÄYTTÖ AIHEUTTAA: java.sql.SQLSyntaxErrorException: Unknown column 'comment0_.post_time' in 'field list'
        // this.commentRepository.findAll()
        System.out.println("getAllComments kommentit noudettu");
        
        return (List<Comment>) this.commentRepository.findAll();
    }

    public void addComment(String name, String comment) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date date = new Date();
        if (name == null) {
            commentRepository.save(new Comment("Anonymous Internet user", comment, dateFormat.format(date)));
        } else {
            commentRepository.save(new Comment(name, comment, dateFormat.format(date)));
        }
    }

}
