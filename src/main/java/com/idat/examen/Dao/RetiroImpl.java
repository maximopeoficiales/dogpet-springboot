package com.idat.examen.Dao;

import java.util.List;
import java.util.Optional;

import com.idat.examen.Interfaces.IRetiro;
import com.idat.examen.Models.Retiro;
import com.idat.examen.Services.IRetiroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetiroImpl implements IRetiroService {

     @Autowired
     IRetiro dao;

     @Override
     public List<Retiro> findAll() {
          return (List<Retiro>) dao.findAll();
     }

     @Override
     public Optional<Retiro> findByCodRet(int cod_ret) {
          return dao.findById(cod_ret);
     }

     @Override
     public void save(Retiro c) {
          dao.save(c);
     }

     @Override
     public void delete(int cod_ret) {
          dao.deleteById(cod_ret);
     }

     @Override
     public List<Retiro> findByCliente(int n_cuenta) {

          return dao.findAllByCliente(n_cuenta);
     }

}
