package com.idat.examen.controllers;

import java.util.List;

import com.idat.examen.crud.ICategoryCR;
import com.idat.examen.crud.IVendorCR;
import com.idat.examen.models.Product;
import com.idat.examen.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    // inyeccion de dependencias de productos , vendor,categorias
    @Autowired
    private ProductService productDao;

    @Autowired
    private IVendorCR vendorDao;

    @Autowired
    private ICategoryCR categoryDao;

    // lista todos los productos
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

    // formulario para crear producto
    @GetMapping("/producto/crear")
    public String saveProduct(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + userDetails.getAuthorities());
        // solo si es admin puede ingresar aqui
        if (userDetails.getAuthorities().toString().contains("ROLE_ADMIN")) {
            // envia un objeto producto que se rellenara en el formulario
            model.addAttribute("edit", false);
            model.addAttribute("producto", new Product());
            model.addAttribute("vendors", vendorDao.findAll());
            model.addAttribute("categorys", categoryDao.findAll());
            return "admin/new_producto";
        }
        // si no es admin redirige a catalogo de productos
        return "redirect:/catalogo-de-productos";
    }

    // SUBMIT de formulario de creacion
    @PostMapping("/producto/crear")
    public String saveProductPost(Authentication authentication, Product product) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + userDetails.getAuthorities());
        // solo si es admin puede ingresar aqui
        if (userDetails.getAuthorities().toString().contains("ROLE_ADMIN")) {
            // guardo el producto
            productDao.save(product);
            // redirijo al listado de productos
            return "redirect:/admin/productos";
        }
        // si no es admin
        return "redirect:/catalogo-de-productos";
    }

    // edicion de producto , capturo parametro de la url
    @GetMapping("/producto/editar/{idProduct}")
    public String editarProduct(@PathVariable int idProduct, Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + userDetails.getAuthorities());
        // solo si es admin puede ingresar aqui
        if (userDetails.getAuthorities().toString().contains("ROLE_ADMIN")) {
            // le envio variables a la vista como productos,proveedores,categorias
            model.addAttribute("edit", true);
            model.addAttribute("producto", productDao.getProduct(idProduct));
            model.addAttribute("vendors", vendorDao.findAll());
            model.addAttribute("categorys", categoryDao.findAll());
            return "admin/new_producto";
        }
        return "redirect:/catalogo-de-productos";
    }

    // elimino producto por la url
    @GetMapping("/producto/eliminar/{idProduct}")
    public String eliminarProduct(@PathVariable int idProduct, Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + userDetails.getAuthorities());
        // solo si es admin puede ingresar aqui
        if (userDetails.getAuthorities().toString().contains("ROLE_ADMIN")) {
            // elimino producto
            productDao.delete(idProduct);
            return "redirect:/admin/productos";
        }
        
        // redirige si no es admin
        return "redirect:/catalogo-de-productos";
    }

}
