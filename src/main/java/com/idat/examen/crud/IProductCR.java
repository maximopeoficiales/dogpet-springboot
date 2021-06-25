package com.idat.examen.crud;

import java.util.List;
import java.util.Optional;

import com.idat.examen.models.Product;

import org.springframework.data.repository.CrudRepository;

public interface IProductCR extends CrudRepository<Product, Integer> {
     Optional<Product> findBySlug(String slug);

     Optional<List<Product>> findByIdCategory(Integer idCategory);

     Optional<List<Product>> findByIdVendor(Integer idVendor);

     Optional<List<Product>> findByNameLike(String name);

}
