package com.idat.examen.Services;

import java.util.List;
import java.util.Optional;

import com.idat.examen.Models.Cliente;

import org.springframework.stereotype.Repository;

@Repository
public interface IClienteService {
     public List<Cliente> findAll();

     public Optional<Cliente> findByNCuenta(int n_cuenta);

     public void save(Cliente c);

     // public void update(Cliente c);

     public void delete(int n_cuenta);
}
