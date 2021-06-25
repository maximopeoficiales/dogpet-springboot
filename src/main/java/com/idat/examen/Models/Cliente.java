package com.idat.examen.Models;

// import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cliente")
public class Cliente {

     @Id
     // @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int n_cuenta;
     @Column(length = 30)
     private String nombre;
     @Column(length = 40)
     private String apellido;
     @Column(length = 8)
     private String dni;

     // // un usuario pude muchos roles
     // @OneToMany
     // @JoinColumn(name = "cliente")
     // private List<Deposito> depositos;

     // // un usuario pude muchos roles
     // @OneToMany
     // @JoinColumn(name = "cliente")
     // private List<Retiro> retiros;

}
