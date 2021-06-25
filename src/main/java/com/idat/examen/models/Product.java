package com.idat.examen.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer idProduct;

     @Column(name = "id_category")
     private Integer idCategory;

     @Column(name = "id_vendor")
     private Integer idVendor;

     @Column(length = 50)
     private String name;

     @Column(unique = true)
     private Integer sku;

     private String slug;

     private Double price;

     @Column(name = "sale_price")
     private Double salePrice;

     @Column(length = 300)
     private String description;

     @Column(length = 300, name = "thumbnail_url")
     private String thumbnailUrl;

     @Column(name = "date_created")
     private LocalDateTime dateCreated;

     private Integer stock;

     // muchos productos tienen una categoria
     // name : fk
     // @JsonIgnore
     @ManyToOne
     @JoinColumn(name = "id_category", insertable = false, updatable = false)
     private Category category;

     // @JsonIgnore
     @ManyToOne
     @JoinColumn(name = "id_vendor", insertable = false, updatable = false)
     private Vendor vendor;

   
}
