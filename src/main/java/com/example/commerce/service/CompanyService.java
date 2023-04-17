package com.example.commerce.service;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.commerce.entity.Company;
import com.example.commerce.repository.CompanyRepository;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    public Company getById(UUID id){
        return companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found company " + id.toString()));
    }

    public Company add(Company company){
        return companyRepository.save(company);
    }
    

    public Company update(UUID id,Company company){
        company.setName(company.getName());
        return companyRepository.saveAndFlush(company);
    }

    public void delete(UUID id){
        companyRepository.deleteById(id);
    }

}