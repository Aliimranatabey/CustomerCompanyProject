package com.example.commerce.repository;
import com.example.commerce.entity.Company;
import com.example.commerce.entity.Customer;
import com.example.commerce.entity.Gender;
import java.util.List;
import java.util.UUID;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "customer")
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query("SELECT c FROM Customer c LEFT OUTER JOIN c.company sc WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', CONCAT(:name, concat('%')))) AND "
            + "LOWER(c.surname) LIKE LOWER(CONCAT('%', CONCAT(:surname, concat('%')))) AND "
            + "LOWER(c.email) LIKE LOWER(CONCAT('%', CONCAT(:email, concat('%')))) AND "
            + "LOWER(c.password) LIKE LOWER(CONCAT('%', CONCAT(:password, concat('%')))) AND "
            + "LOWER(c.gender) LIKE LOWER(CONCAT('%', CONCAT(:gender, concat('%')))) AND "
            + "LOWER(c.birthday) LIKE LOWER(CONCAT('%', CONCAT(:birthday, concat('%')))) AND "
            + "(:company='' OR LOWER(sc.name) LIKE LOWER(CONCAT('%', CONCAT(:company, concat('%')))))")
    List<Customer> findAllSearch(@Param("name") String name, @Param("surname") String surname,
            @Param("email") String email, @Param("password") String password,
            @Param("company") Company company);
        Page<Customer> findByCustomer(@Param("name") String name, @Param("surname") String surname,@Param("email") String email,@Param("password") String password, @Param("gender") Gender gender, Pageable pageable);
}
