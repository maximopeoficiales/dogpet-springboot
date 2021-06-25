package com.idat.examen.Interfaces;

import com.idat.examen.Models.Deposito;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

public interface IDeposito extends JpaRepository<Deposito, Integer> {

}
