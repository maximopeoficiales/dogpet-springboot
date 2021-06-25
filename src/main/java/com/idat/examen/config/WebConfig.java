package com.idat.examen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
     @Override
     public void addViewControllers(ViewControllerRegistry reg) {
          // en este controlador se agregar enpoints que no pasan por un
          // security(middleware)
          // por defecto usa la vista login
          // reg.addViewController("/").setViewName("index");
          reg.addViewController("/login").setViewName("login");
          reg.setOrder(Ordered.HIGHEST_PRECEDENCE);
     }
}
