package com.idat.examen.services;

import java.util.List;
import java.util.Optional;

import com.idat.examen.crud.IUsuarioCR;
import com.idat.examen.models.Client;
import com.idat.examen.repository.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUsuarioRepository {

     @Autowired
     IUsuarioCR dao;

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
