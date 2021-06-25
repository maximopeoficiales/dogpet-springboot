package com.idat.examen.crud;

import com.idat.examen.models.Category;

import org.springframework.data.repository.CrudRepository;

public interface ICategoryCR extends CrudRepository<Category, Integer> {

}
