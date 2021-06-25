package com.idat.examen.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String user;
     private String password;
}
