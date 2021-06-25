package com.idat.examen.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
     @Autowired
     private UserDetailsService userDetailsService;

     @Bean // spring pueda usar directamente esta funcion
     public BCryptPasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
     }

     @Autowired // se le pasa las configuraciones que hemos creado en JPA
     public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
          builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
     }

     @Override
     protected void configure(HttpSecurity http) throws Exception {
          http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
     }
}
