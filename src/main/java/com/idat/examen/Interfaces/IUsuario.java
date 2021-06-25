package com.idat.examen.Interfaces;

import com.idat.examen.Models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends JpaRepository<Usuario, Integer> {
     Usuario findByUser(String user);
}
