package com.example.commerce.entity;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="customer")
public class Customer {
     @Id
     @GeneratedValue(generator = "UUID")
     @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
     @Column(name="id", columnDefinition = "VARCHAR(255)",nullable = false)
     private UUID id;

     //unique default olarak zaten false değer girer .
     @Column(name="name",length = 50,nullable = false,unique = false)
     private String name;

     @Column(name="surname",length = 50,nullable = false)
     private String surname;

     @Column(name="email",length = 50,nullable = false)
     private String email;

     @Column(name="password",length = 50,nullable = false)
     private String password;

     @Column(name="gender",length = 20,nullable = false)
     private String gender;

     @DateTimeFormat(pattern="dd/MM/yyyy")
     @Column(name="birthday",length = 20,nullable = false)
     private Date birthday;

     


     

}
