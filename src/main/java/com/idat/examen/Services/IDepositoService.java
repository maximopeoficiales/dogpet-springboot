package com.idat.examen.Services;

import java.util.List;
import java.util.Optional;

import com.idat.examen.Models.Deposito;

import org.springframework.stereotype.Repository;

@Repository
public interface IDepositoService {
     public List<Deposito> findAll();

     public Optional<Deposito> findByCodDep(int cod_dep);

     public void save(Deposito c);

     public void delete(int cod_dep);
}
