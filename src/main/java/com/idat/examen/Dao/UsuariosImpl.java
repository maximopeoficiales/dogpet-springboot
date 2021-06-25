package com.idat.examen.Dao;

import java.util.List;
import java.util.Optional;

import com.idat.examen.Interfaces.IUsuario;
import com.idat.examen.Models.Usuario;
import com.idat.examen.Services.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosImpl implements IUsuarioService {

     @Autowired
     IUsuario dao;

     @Override
     public List<Usuario> findAll() {
          return (List<Usuario>) dao.findAll();
     }

     @Override
     public Optional<Usuario> findByID(int id) {
          return dao.findById(id);
     }

     @Override
     public void save(Usuario c) {
          dao.save(c);
     }

     @Override
     public void delete(int id) {
          dao.deleteById(id);
     }

}
