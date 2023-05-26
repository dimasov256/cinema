package com.cinema.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class RestSecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("matt").password("{noop}secret").authorities("ROLE_ADMIN")
                .and()
                .withUser("jane").password("{noop}secret").authorities("ROLE_USER");

        //TODO password should be encoded
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/api/basicAuth/**").permitAll()
                .antMatchers("/api/basicAuth/**").hasAnyRole("ADMIN", "USER")
                .and()
                .httpBasic();

        security
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/api/v1/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/films/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/cities/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/filmsWithDate/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/cinemaHalls/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/v1/users/**").hasRole("ADMIN")
                //TODO need integrate gateway with security
                .and()
                .addFilter(new JWTAuthFilter(authenticationManager()));
    }
}
