package com.example.commerce.service;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.commerce.entity.Customer;
import com.example.commerce.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getById(UUID id){
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found customer " + id.toString()));
    }

    public Customer add(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(UUID id,Customer customer){
        return customerRepository.saveAndFlush(customer);   
    }

    public void delete(UUID id){
        customerRepository.deleteById(id);
    }
}