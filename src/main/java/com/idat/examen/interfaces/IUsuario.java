package com.idat.examen.interfaces;

import com.idat.examen.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends JpaRepository<Client, Integer> {
     Client findByUser(String user);
}
