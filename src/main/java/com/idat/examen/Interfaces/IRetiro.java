package com.idat.examen.Interfaces;

import java.util.List;
// import java.util.Optional;

import com.idat.examen.Models.Retiro;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.jpa.repository.Query;

public interface IRetiro extends JpaRepository<Retiro, Integer> {
     // @Query("SELECT u FROM retiros u WHERE u.cliente = ?1")
     List<Retiro> findAllByCliente(int cliente);
}
