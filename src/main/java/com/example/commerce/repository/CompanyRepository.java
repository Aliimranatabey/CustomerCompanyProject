package com.example.commerce.repository;
import java.util.UUID;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.commerce.entity.Company;

@RepositoryRestResource(path = "company")
public interface CompanyRepository extends JpaRepository<Company,UUID>{
    // @Query("SELECT c from company c WHERE LOWER(c.name) LIKE LOWER(concat('%',concat(:name,concat('%')))) AND LOWER(c.url) LIKE LOWER(concat('%',concat(:url,concat('%'))))")
    // Page<Company> findByCompany(@Param("name") String name,@Param("url") String url,Pageable p);

}

