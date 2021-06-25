package com.idat.examen.Controllers;

import java.util.List;
import java.util.Optional;

import com.idat.examen.Models.Cliente;
import com.idat.examen.Models.Retiro;
import com.idat.examen.Models.Usuario;
import com.idat.examen.Services.IClienteService;
import com.idat.examen.Services.IRetiroService;
// import com.idat.examen.Services.IUsuarioService;
import com.idat.examen.Services.IUsuarioService;

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
     private IClienteService clienteDao;

     @Autowired
     private IUsuarioService usuarioDao;

     @Autowired
     private IRetiroService retiroDao;

     @GetMapping("/menu")
     public String menu() {
          return "index";
     }

     /* clientes */
     @GetMapping("/clients")
     public String clientes(Model model) {
          List<Cliente> clientes = clienteDao.findAll();
          model.addAttribute("clientes", clientes);
          return "cliente/index";
     }

     @GetMapping("/new_client")
     public String agregarcli(Model model) {
          model.addAttribute("cliente", new Cliente());
          return "cliente/new";
     }

     @PostMapping("/new_client")
     public String savecli(Cliente c) {
          clienteDao.save(c);
          return "redirect:/clients";
     }

     @GetMapping("/client/{idcliente}")
     public String editarcli(@PathVariable int idcliente, Model model) {
          Optional<Cliente> clientes = clienteDao.findByNCuenta(idcliente);
          model.addAttribute("cliente", clientes);
          return "cliente/new";
     }

     @GetMapping("/deleteclient/{idcliente}")
     public String deletecli(@PathVariable int idcliente) {
          clienteDao.delete(idcliente);
          return "redirect:/clients";
     }

     /* ------------------------- */
     /* usuarios */
     @GetMapping("/users")
     public String usuarios(Model model) {
          List<Usuario> users = usuarioDao.findAll();
          model.addAttribute("usuarios", users);
          return "usuario/index";
     }

     @GetMapping("/new_user")
     public String agregarUser(Model model) {
          model.addAttribute("usuario", new Usuario());
          return "usuario/new";
     }

     @PostMapping("/new_user")
     public String saveUser(Usuario c) {
          usuarioDao.save(c);
          return "redirect:/users";
     }

     @GetMapping("/user/{iduser}")
     public String editarUser(@PathVariable int iduser, Model model) {
          Optional<Usuario> users = usuarioDao.findByID(iduser);
          model.addAttribute("usuario", users);
          return "usuario/new";
     }

     @GetMapping("/deleteuser/{iduser}")
     public String deleteUser(@PathVariable int iduser) {
          usuarioDao.delete(iduser);
          return "redirect:/users";
     }

     /* Retiros */
     // @GetMapping("/buscarRetiros")
     // public String buscarRetiros(Model model) {
     // // model.addAttribute("retiros", new Retiro());
     // return "retiro/search";
     // }

     @GetMapping("/buscarRetiros")
     public String saveUser(@RequestParam(value = "n_cuenta", required = false) Integer n_cuenta, Model model) {
          if (n_cuenta != null) {
               List<Retiro> retiros = retiroDao.findByCliente(n_cuenta);
               model.addAttribute("retiros", retiros);
               return "retiro/search";
          } else {
               model.addAttribute("retiros", new Retiro());
               return "retiro/search";
          }

     }

     @GetMapping("/crearRetiro")
     public String agregarRetiro(Model model) {
          model.addAttribute("retiro", new Retiro());
          return "retiro/new";
     }

     @PostMapping("/crearRetiro")
     public String guardarRetiro(Retiro c) {
          retiroDao.save(c);
          return "redirect:/buscarRetiros";
     }
}
