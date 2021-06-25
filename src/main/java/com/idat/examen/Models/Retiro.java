package com.idat.examen.Models;

// import java.util.Date;

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
@Table(name = "retiros")
public class Retiro {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int cod_ret;
     private String fecha;
     private int monto;
     private int cliente;
}
