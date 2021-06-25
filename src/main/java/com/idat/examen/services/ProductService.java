package com.idat.examen.services;

import java.util.List;
import java.util.Optional;

import com.idat.examen.crud.IProductCR;
import com.idat.examen.models.Product;
import com.idat.examen.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductRepository {
    @Autowired
    IProductCR dao;

    @Override
    public List<Product> getAll() {
        return (List<Product>) dao.findAll();
    }

    @Override
    public Optional<Product> getProduct(int idProduct) {
        return dao.findById(idProduct);
    }

    @Override
    public void save(Product product) {
        dao.save(product);
    }

    @Override
    public void delete(int idProduct) {
        dao.deleteById(idProduct);
    }

    @Override
    public Optional<List<Product>> findByIdCategory(Integer idCategory) {
        return dao.findByIdCategory(idCategory);
    }

    @Override
    public Optional<List<Product>> findByIdVendor(Integer idVendor) {
        return dao.findByIdVendor(idVendor);
    }

    @Override
    public Optional<List<Product>> findByNameLike(String name) {
        return dao.findByNameLike(name);
    }

}
