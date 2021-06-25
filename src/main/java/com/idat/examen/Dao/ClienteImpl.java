package com.idat.examen.Dao;

import java.util.List;
import java.util.Optional;

import com.idat.examen.Interfaces.ICliente;
import com.idat.examen.Models.Cliente;
import com.idat.examen.Services.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteImpl implements IClienteService {

     @Autowired
     ICliente dao;

     @Override
     public List<Cliente> findAll() {
          return (List<Cliente>) dao.findAll();
     }

     @Override
     public Optional<Cliente> findByNCuenta(int n_cuenta) {
          return dao.findById(n_cuenta);
     }

     @Override
     public void save(Cliente c) {
          dao.save(c);
     }

     @Override
     public void delete(int idcliente) {
          dao.deleteById(idcliente);
     }

    

}
