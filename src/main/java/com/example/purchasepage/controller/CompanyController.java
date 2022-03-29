package com.example.purchasepage.controller;

import com.example.purchasepage.pojo.Company;
import com.example.purchasepage.pojo.RetResult;
import com.example.purchasepage.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("company")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @PostMapping("/add")
    public RetResult addCompany(Company company){
        if(companyService.addCompany(company)){
            return new RetResult(200,"add successfully", companyService.getAllCompanies());
        }
        return new RetResult(404,"add failed",companyService.getAllCompanies());
    }

    @PostMapping("/update")
    public RetResult updateCompany(Company company){
        RetResult result;
        if(companyService.updateCompany(company)==false){
            return new RetResult(404,"updated failed",companyService.getAllCompanies());
        }
        return allCompanies();
    }

    @GetMapping("/list")
    public RetResult allCompanies(){
        RetResult<List<Company>> result;
        List<Company> companies;
        companies = companyService.getAllCompanies();
        if(companies == null){
            result = new RetResult<List<Company>>(404,"no company",null);
        }else{
            result = new RetResult(200,"success",companies);
        }
        return result;
    }

    @GetMapping("/search/{id}")
    public RetResult getCompany(@PathVariable("id") Integer id){
        RetResult result;
        if(companyService.getCompanyById(id) == null){
            result = new RetResult(404,"no exist the company",null);
            return result;
        }
        result = new RetResult(200,"search successfully",companyService.getCompanyById(id));
        return result;
    }

    @GetMapping("delete/{id}")
    public  RetResult delCompany(@PathVariable("id") Integer id){
        if(companyService.deleteCompany(id) == false){
            return new RetResult(404,"delete failed",null);
        }
        return  new RetResult(200,"success",companyService.getAllCompanies());
    }
}
