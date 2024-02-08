package com.nnm.firstjob.company.impl;

import com.nnm.firstjob.company.company;
import com.nnm.firstjob.company.companyrepo;
import com.nnm.firstjob.company.companyservice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class companyserviceimpl implements companyservice {

    private companyrepo companyrepo;

    public companyserviceimpl(com.nnm.firstjob.company.companyrepo companyrepo) {
        this.companyrepo = companyrepo;
    }

    @Override
    public List<company> getallcompanies() {
        return companyrepo.findAll();
    }

    @Override
    public boolean updatecompany(company company, Long id) {
        Optional<company>companyOptional=companyrepo.findById(id);
        if (companyOptional.isPresent()){
            company companytoupdate =companyOptional.get();
            companytoupdate.setDiscription(company.getDiscription());
            companytoupdate.setName(company.getName());
            companytoupdate.setDiscription(company.getDiscription());
            companyrepo.save(companytoupdate);
            return true;
        }
        return false;
    }

    @Override
    public void craetecompany(company company) {
        companyrepo.save(company);
    }


}
