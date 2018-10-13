/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.service;

import com.mycompany.apachebootworks.repository.CommentRepository;
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
    
}
