package com.example.commerce.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.commerce.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,UUID>{
    
}
