/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachebootworks.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // com.giffing.wicket.spring.boot.starter vaatii tämän jostain syystä. Muutoin tulee jäätävä läjä compile erroreita
    @Override
    @Bean(name = "authenticationManager")
    public AuthenticationManager authenticationManagerBean() throws Exception {
        System.out.println("<---------- AUTHENTICATION MANAGER RETURNED ------------->");
        return super.authenticationManagerBean();
    }

    // Spring Security configuraatiota. Jos tätä ei ole, niin ei päästä koko verkkosivulle - koska: spring-boot-starter-security
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("<----------- HTTP AUTHORISOINNIT TSEKATTU ----------->");
        http.authorizeRequests().antMatchers("/").permitAll();
    }

    // (EI TUOTANTOON) Testaamiseen usernamet ja passwordit inmemory databaseen.
    // Tämä pitää olla myös, koska muuten antaa läjän "authenticationManager" erroreita
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder().username("testi").password("testi").roles("ADMIN").build();
        System.out.println("<------------ TESTITUNNUKSET MEMORYBANKISSA ------------------->");
        return new InMemoryUserDetailsManager(user);
    }
}
