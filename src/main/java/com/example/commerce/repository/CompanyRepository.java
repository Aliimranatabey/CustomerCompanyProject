package com.example.commerce.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.commerce.entity.Company;

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company,UUID>{
    
}
