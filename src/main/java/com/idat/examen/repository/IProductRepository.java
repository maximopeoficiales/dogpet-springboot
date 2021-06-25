package com.idat.examen.repository;

import java.util.List;
import java.util.Optional;

import com.idat.examen.models.Product;

public interface IProductRepository {
    List<Product> getAll();

    Optional<Product> getProduct(int idProduct);

    void save(Product product);

    void delete(int idProduct);

    Optional<List<Product>> findByIdCategory(Integer idCategory);

    Optional<List<Product>> findByIdVendor(Integer idVendor);

    Optional<List<Product>> findByNameLike(String name);

}
