/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.repository;

import org.springframework.data.repository.CrudRepository;

/**
 *  Model layer: Suorat tietokantayhteydet, ei busines logiikkaa. 
 * @author tommib
 */
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    
}
