package com.example.purchasepage.service;

import com.example.purchasepage.mapper.CompanyMapper;
import com.example.purchasepage.pojo.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyService {
    @Autowired
    CompanyMapper companyMapper;

    public boolean addCompany(Company company){
        if(getCompanyById(company.getId())==null){
            companyMapper.addCompany(company);
            return true;
        }
        return false;
    }

    public boolean updateCompany(Company company){
        boolean flag = false;
        if(company == null){
            return false;
        }
        companyMapper.updateCompany(company);
        return true;
    }

    public List<Company> getAllCompanies(){
        List<Company> companies;
        companies = companyMapper.getAllCompanies();
        return companies;
    }

    public Company getCompanyById(Integer id){
        return companyMapper.getCompanyById(id);
    }

    public boolean deleteCompany(Integer id){
        if(companyMapper.getCompanyById(id) == null){
            return false;
        }
        companyMapper.deleteCompany(id);
        return true;
    }
}
