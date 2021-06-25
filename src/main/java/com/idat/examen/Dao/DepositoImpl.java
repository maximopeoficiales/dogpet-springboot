package com.idat.examen.Dao;

import java.util.List;
import java.util.Optional;

import com.idat.examen.Interfaces.IDeposito;
import com.idat.examen.Models.Deposito;
import com.idat.examen.Services.IDepositoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositoImpl implements IDepositoService {

     @Autowired
     IDeposito dao;

     @Override
     public List<Deposito> findAll() {
          return (List<Deposito>) dao.findAll();
     }

     @Override
     public Optional<Deposito> findByCodDep(int cod_dep) {
          return dao.findById(cod_dep);
     }

     @Override
     public void save(Deposito c) {
          dao.save(c);
     }

     @Override
     public void delete(int cod_dep) {
          dao.deleteById(cod_dep);
     }

}
