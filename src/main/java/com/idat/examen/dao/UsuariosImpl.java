package com.idat.examen.dao;

import java.util.List;
import java.util.Optional;

import com.idat.examen.interfaces.IUsuario;
import com.idat.examen.models.Client;
import com.idat.examen.services.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosImpl implements IUsuarioService {

     @Autowired
     IUsuario dao;

     @Override
     public List<Client> findAll() {
          return (List<Client>) dao.findAll();
     }

     @Override
     public Optional<Client> findByID(int id) {
          return dao.findById(id);
     }

     @Override
     public void save(Client c) {
          dao.save(c);
     }

     @Override
     public void delete(int id) {
          dao.deleteById(id);
     }

}
