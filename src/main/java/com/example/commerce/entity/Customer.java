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

     public Customer(){}

     public Customer(UUID id , String name, String surname, String email , String password ,String gender , Date birthday){

          this.id=id;
          this.name=name;
          this.surname=surname;
          this.email=email;
          this.password=password;
          this.gender=gender;
          this.birthday=birthday;

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

     public String getSurname(){
          return surname;
     }

     public void setSurname(String surname){
          this.surname=surname;
     }

     public String getEmail(){
          return email;
     }

     public void setEmail(String email){
          this.email=email;
     }

     public String getPassword(){
          return password;
     }

     public void setPassword(String password){
          this.password=password;
     }

     public String getGender(){
          return gender;
     }

     public void setGender(String gender){
          this.gender=gender;
     }

     public Date getBirthday(){
          return birthday;
     }

     public void setBirthday(Date birthday){
          this.birthday=birthday;
     }
}