/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.front.loginpage;

import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 *
 * @author tommib
 */
@Component
public class UserPOJO implements Serializable {

    private String username;
    private String password;

    public UserPOJO() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
