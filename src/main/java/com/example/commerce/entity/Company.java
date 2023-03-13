package com.example.commerce.entity;



import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="company")
public class Company {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private UUID id;

    @Column(name="name",nullable=false,unique=true)
    private String name;

    @Column(name="url",nullable=false)
    private String url;

    @Lob
    @Column(name="image",nullable=true,columnDefinition="BLOB")
    private byte[] photo;

}
