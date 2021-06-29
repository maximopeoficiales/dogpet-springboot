package com.idat.examen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// le indico a spring que sera una clase de configuracion y que la seguridad la manejara esta clase
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
     // al hacer instancia de userDetailService estamos llamado a lo declarado en UsuarioConfig.java
     @Autowired
     private UserDetailsService userDetailsService;

     @Bean // spring pueda usar directamente esta funcion
     public BCryptPasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
     }

     @Autowired // se le pasa las configuraciones que hemos creado en JPA
     public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
          // verifica que si la contraseña ingresa por el usuario equivale a la guarda en la bd
          builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
     }

     @Override
     protected void configure(HttpSecurity http) throws Exception {
          // habilita el acceso en la url assest/** para las imagenes
          //  se asigna la pagina login y tambien que pagina sera la pagina de login-error
          http.csrf().disable().authorizeRequests().antMatchers("/assets/**").permitAll().anyRequest().authenticated()
                    .and().formLogin().loginPage("/login").failureUrl("/login-error.html")
                    .permitAll();
     }
}
