package com.idat.examen.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
     public static void main(String[] args) {
          // esto es un generador de contraseñas encriptadas
          var password = "jean";
          System.out.println("password: " + password);
          System.out.println("password: " + encriptarPassword(password));
     }

     public static String encriptarPassword(String password) {
          // encripta password
          BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
          return encoder.encode(password);
     }
}
