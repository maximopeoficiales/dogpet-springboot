package com.idat.examen.Interfaces;

import com.idat.examen.Models.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICliente extends JpaRepository<Cliente, Integer> {

}
