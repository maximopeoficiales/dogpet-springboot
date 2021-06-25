package com.idat.examen.controllers;

import java.util.List;
import java.util.Optional;

import com.idat.examen.models.Client;
import com.idat.examen.services.IUsuarioService;
import com.idat.examen.util.EncriptarPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class HomeController {

     @Autowired
     private IUsuarioService usuarioDao;

     @GetMapping("/menu")
     public String menu() {
          return "index";
     }

     /* ------------------------- */
     /* usuarios */
     @GetMapping("/users")
     public String usuarios(Model model) {
          List<Client> users = usuarioDao.findAll();
          model.addAttribute("usuarios", users);
          return "usuario/index";
     }

     @GetMapping("/new_user")
     public String agregarUser(Model model) {
          model.addAttribute("usuario", new Client());
          return "usuario/new";
     }

     @PostMapping("/new_user")
     public String saveUser(Client c) {
          c.setPassword(EncriptarPassword.encriptarPassword(c.getPassword());
          usuarioDao.save(c);
          return "redirect:/users";
     }

     @GetMapping("/user/{iduser}")
     public String editarUser(@PathVariable int iduser, Model model) {
          Optional<Client> users = usuarioDao.findByID(iduser);
          model.addAttribute("usuario", users);
          return "usuario/new";
     }

     @GetMapping("/deleteuser/{iduser}")
     public String deleteUser(@PathVariable int iduser) {
          usuarioDao.delete(iduser);
          return "redirect:/users";
     }

}
