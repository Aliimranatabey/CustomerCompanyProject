package com.example.commerce.entity;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
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
    @Column(name="image",nullable=true)
    private byte[] image;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name="customers",columnDefinition = "jsonb",nullable=true)
    private Set<Customer> customers;

    public Company(){}

    public Company(UUID id , String name , String url , byte[] image, Set<Customer> customers){

        this.id=id;
        this.name=name;
        this.url=url;
        this.image=image;
        this.customers=customers;

    }

    public UUID getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url=url;
    }

    public byte[] getImage(){
        return image;
    }

    public void setImage(){
        this.image=image;
    }

    public Set<Customer> getCustomer(){
        return customers;
    }

    public void setCustomer(Set<Customer> customers){
        this.customers=customers;
    }
}
