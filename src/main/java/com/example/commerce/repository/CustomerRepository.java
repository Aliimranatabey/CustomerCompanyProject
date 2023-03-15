package com.example.commerce.repository;
import com.example.commerce.entity.Customer;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,UUID>{
    
}
