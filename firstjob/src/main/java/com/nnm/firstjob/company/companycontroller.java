package com.nnm.firstjob.company;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class companycontroller {
    private final companyservice companyservice;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String>detete(@PathVariable Long id){
        boolean deteted=companyservice.deletecompany(id);
        if (deteted==true) {
            return ResponseEntity.ok("Company Is Deleted with id " + id);
        }else {
            return new ResponseEntity<>("Job Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<company>findcompanybyid(@PathVariable Long id){
        company company=companyservice.findcompanybyid(id);
        if (company!=null)
            return new ResponseEntity<>(company,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
