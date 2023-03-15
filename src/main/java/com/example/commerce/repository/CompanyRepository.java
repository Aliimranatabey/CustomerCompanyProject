package com.example.commerce.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.commerce.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,UUID>{
    
}
