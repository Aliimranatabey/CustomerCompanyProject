package com.example.commerce.service;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
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
        Company oldCompany =  getById(id);
        company.setName(company.getName());
        return companyRepository.saveAndFlush(company);
    }

    public void delete(UUID id){
        companyRepository.deleteById(id);
    }
    public void  saveCompanyToDB(MultipartFile file,String name,String url)
	{
		Company c = new Company();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			c.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		c.setUrl(url);
        c.setName(name);
        companyRepository.save(c);
	}
}