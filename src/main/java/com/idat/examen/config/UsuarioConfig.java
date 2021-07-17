package com.idat.examen.config;

import java.util.ArrayList;

import com.idat.examen.crud.IUsuarioCR;
import com.idat.examen.models.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// se esta sobreescribiendo el servicio userDetailsService 

@Service("userDetailsService")
public class UsuarioConfig implements UserDetailsService {
     // hago una inyeccion de dependencia a IUsuarioCr que tiene los metodos para bd
     @Autowired
     private IUsuarioCR usuarioDao;

     // se le indica que se sobreescribira el metodo loadUserByUsername y que su
     // transaccion es solo de lectura

     // este metodo se ejecuta cuando un usuario presiona el boton submit en el login
     @Override
     @Transactional(readOnly = true)
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          // busca usuario que trata de iniciar sesion
          Client usuario = usuarioDao.findByUser(username);

          if (usuario == null) {
               throw new UsernameNotFoundException(username);
          }
          /* creo array de roles */
          var roles = new ArrayList<GrantedAuthority>();
          // se agregan los tipos de Roles
          roles.add(new SimpleGrantedAuthority(usuario.getRol() == 1 ? "ROLE_ADMIN" : "ROLE_USER"));
          // instancia User de userdetails
          return new User(usuario.getUser(), usuario.getPassword(), roles);
     }

     public String encriptarPassword(String password) {
          // encripta password
          BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
          return encoder.encode(password);
     }
}
