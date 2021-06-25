package com.idat.examen.Services;

import java.util.List;
import java.util.Optional;

import com.idat.examen.Models.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioService {
     public List<Usuario> findAll();

     public Optional<Usuario> findByID(int id);

     public void save(Usuario c);

     public void delete(int id);
}
