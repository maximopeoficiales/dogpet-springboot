package com.idat.examen.Config;

import java.util.ArrayList;

import com.idat.examen.Interfaces.IUsuario;
import com.idat.examen.Models.Usuario;

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

@Service("userDetailsService")
public class UsuarioConfig implements UserDetailsService {
     @Autowired
     private IUsuario usuarioDao;

     @Override
     @Transactional(readOnly = true)
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          // busca usuarios
          Usuario usuario = usuarioDao.findByUser(username);
          if (usuario == null) {
               throw new UsernameNotFoundException(username);
          }
          /* creo array de roles */
          var roles = new ArrayList<GrantedAuthority>();
          // se agregan los tipos de Roles
          roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
          // instancia User de userdetails
          return new User(usuario.getUser(), this.encriptarPassword(usuario.getPassword()), roles);
     }

     public String encriptarPassword(String password) {
          // encripta password
          BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
          return encoder.encode(password);
     }
}
