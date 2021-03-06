package com.idat.examen.repository;

import java.util.List;
import java.util.Optional;

import com.idat.examen.models.Client;

import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository {
     public List<Client> findAll();

     public Optional<Client> findByID(int id);

     public void save(Client c);

     public void delete(int id);
}
