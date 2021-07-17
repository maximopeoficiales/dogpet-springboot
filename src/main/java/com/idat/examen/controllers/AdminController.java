package com.idat.examen.controllers;

import java.util.List;

import com.idat.examen.models.Product;
import com.idat.examen.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private ProductService productDao;

    @GetMapping("/productos")
    public String listaProductos(@RequestParam(value = "query", required = false) String query, Model model,
            Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + userDetails.getAuthorities());
        // solo si es admin puede ingresar aqui
        if (userDetails.getAuthorities().toString().contains("ROLE_ADMIN")) {
            List<Product> products;
            if (query == null) {
                products = productDao.findAll();
            } else {
                products = productDao.findByNameLike(query);
            }
            model.addAttribute("countProducts", products.size());
            model.addAttribute("productos", products);

            return "admin/index";
        }

        return "redirect:/catalogo-de-productos";

    }
}
