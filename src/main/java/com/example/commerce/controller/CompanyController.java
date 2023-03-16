package com.example.commerce.controller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.commerce.entity.Company;
import com.example.commerce.service.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {

    // @Value
    // private String path;
    
    @Autowired
    CompanyService companyService;

    @GetMapping("/test")
    public String getTest(){
        return "TEST SUCCESSFUL";
    }

    @GetMapping("")
    public List<Company> getAll(){
        return companyService.getAll();
    }

    @GetMapping("/getById")
    public Company getById(@RequestParam("id") UUID id){
        return companyService.getById(id);
    }

    @PostMapping("")
    public String add(@RequestBody Company company){
        companyService.add(company);
        return "SUCCESSFUL ADDED";
    }

    @PutMapping("")
    public String update(@RequestBody Company company){
        companyService.update(company);
        return "SUCCESSFUL UPDATED";
    }

    @DeleteMapping("")
    public String delete(@RequestParam("id") UUID id){
        companyService.delete(id);
        return "SUCCESSFUL DELETED";
    }

    @PostMapping("/upload-file")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception{
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        // String Path_Directory = "D:/FuBahar4/internWorkspace/commerce/src/main/resources/static"; // static olarak yolu belirtebiliriz.
        String Path_Directory = new ClassPathResource("static/image/").getFile().getAbsolutePath(); // proje içindekideki dosyayı belirttikten sonra bize o dosyanın pcdeki kesin yolunu verir.
        Files.copy(file.getInputStream(), Paths.get(Path_Directory + File.separator + file.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING  );
        return "SUCCESSFUL IMAGE";
    }
}
