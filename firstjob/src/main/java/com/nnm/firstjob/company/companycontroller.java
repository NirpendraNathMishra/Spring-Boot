package com.nnm.firstjob.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class companycontroller {
    private companyservice companyservice;

    public companycontroller(companyservice companyservice) {
        this.companyservice = companyservice;
    }
    @GetMapping
    public ResponseEntity<List<company>> getallcomaney(){
        return new ResponseEntity<>(companyservice.getallcompanies(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>updatecompany(@PathVariable Long id,@RequestBody company company){
        companyservice.updatecompany(company,id);
        return new ResponseEntity<>("company updated sucessfully", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String>addcompany(@RequestBody company company){
        companyservice.craetecompany(company);
        return new ResponseEntity<>("Company Added sucessfully", HttpStatus.OK);
    }
}
