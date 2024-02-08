package com.nnm.firstjob.company;

import java.util.List;

public interface companyservice {
    List<company>getallcompanies();
    boolean updatecompany(company company, Long id);
    void craetecompany(company company);
}
