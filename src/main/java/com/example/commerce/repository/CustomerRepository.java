package com.example.commerce.repository;
import com.example.commerce.entity.Customer;
// import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "customer")
public interface CustomerRepository extends JpaRepository<Customer,UUID>{
    
    // @Query("SELECT c from Customer c LEFT OUTER JOIN c.company sc WHERE LOWER(c.name) LIKE LOWER(concat('%', concat(:name,concat('%')))) AND "
    //                     + "LOWER(c.surname) LIKE LOWER(concat('%', concat(:surname,concat('%')))) AND "
    //                     + "LOWER(c.email) LIKE LOWER(concat('%', concat(:email,concat('%')))) AND "
    //                     + "LOWER(c.password) LIKE LOWER(concat('%', concat(:password,concat('%')))) AND "
    //                     + "(:company='' OR LOWER(sc.name) LIKE LOWER(concat('%', concat(:company,concat('%'))))) AND ")
    //                     List<Customer> findAllSearch(@Param("name") String name, @Param("surname") String surname,
    //                     @Param("email") String email, @Param("password") Integer password,
    //                     @Param("company") String company);
}


