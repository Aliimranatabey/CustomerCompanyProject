// package com.example.commerce.entity;

// import java.util.UUID;

// import org.hibernate.annotations.GenericGenerator;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name="customer_company")
// public class CustomerCompany {
//     @Id
//     @GeneratedValue(generator = "UUID")
//     @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//     @Column(name="id",nullable = false)
//     private UUID id;

//     private UUID customer_id;

//     private UUID company_id;

//     CustomerCompany(){}

//     CustomerCompany(UUID id,UUID customer_id,UUID company_id){
//         this.id=id;
//         this.customer_id=customer_id;
//         this.company_id=company_id;
//     }

//     public UUID getId(){
//         return id;
//     }

//     public void setId(UUID id){
//         this.id=id;
//     }

//     public UUID getCustomer_id(){
//         return customer_id;
//     }

//     public void setCustomer_id(UUID customer_id){
//         this.customer_id=customer_id;
//     }

//     public UUID getCompany_id(){
//         return company_id;
//     }

//     public void setCompany_id(UUID company_id){
//         this.company_id=company_id;
//     }
// }
