package com.example.commerce.repository;
import java.io.File;
import java.util.UUID;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.commerce.entity.Company;

@RepositoryRestResource(path = "company")
public interface CompanyRepository extends JpaRepository<Company, UUID> {

    @Query("SELECT c from Company c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', CONCAT(:name, ('%')))) AND LOWER(c.url) LIKE LOWER(CONCAT('%', CONCAT(:url, concat('%')))) AND LOWER(c.image) LIKE LOWER(CONCAT('%', CONCAT(:image, concat('%'))))")
    Page<Company> findByCompany(@Param("name") String name, @Param("url") String url,@Param("image") File image, Pageable pageable);

}
