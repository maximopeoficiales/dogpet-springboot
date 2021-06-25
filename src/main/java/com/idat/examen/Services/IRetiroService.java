package com.idat.examen.Services;

import java.util.List;
import java.util.Optional;

import com.idat.examen.Models.Retiro;

import org.springframework.stereotype.Repository;

@Repository
public interface IRetiroService {
     public List<Retiro> findAll();

     public Optional<Retiro> findByCodRet(int cod_ret);

     public List<Retiro> findByCliente(int n_cuenta);

     public void save(Retiro c);

     public void delete(int cod_ret);
}
