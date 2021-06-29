package com.idat.examen.crud;

import com.idat.examen.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

public interface IUsuarioCR extends JpaRepository<Client, Integer> {
     // buscara por usuario
     Client findByUser(String user);
}
