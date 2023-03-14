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
    @Column(name="image",nullable=true)
    private byte[] image;

    public Company(){}

    public Company(UUID id , String name , String url , byte[] image){

        this.id=id;
        this.name=name;
        this.url=url;
        this.image=image;

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
}
