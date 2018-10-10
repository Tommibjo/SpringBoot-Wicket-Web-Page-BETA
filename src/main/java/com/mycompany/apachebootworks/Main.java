package com.mycompany.apachebootworks;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tommib
 */
@SpringBootApplication
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(Main.class).run(args);
    }
    
}
