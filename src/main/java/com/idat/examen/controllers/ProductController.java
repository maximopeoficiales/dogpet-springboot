package com.idat.examen.controllers;

import java.util.List;
import java.util.Optional;

import com.idat.examen.models.Product;
import com.idat.examen.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class ProductController {

     @Autowired
     private ProductService productDao;

     @GetMapping("/catalogo-de-productos")
     public String index(@RequestParam(value = "query", required = false) String query, Model model) {

          if (query == null) {
               List<Product> products = productDao.findAll();
               model.addAttribute("productos", products);
               return "producto/index";
          } else {
               List<Product> products = productDao.findByNameLike(query);
               model.addAttribute("productos", products);
               return "producto/index";
          }
     }

}
