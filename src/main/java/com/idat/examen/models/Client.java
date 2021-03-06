package com.idat.examen.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class Client {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String user;
     private String password;
     private int rol;
}
