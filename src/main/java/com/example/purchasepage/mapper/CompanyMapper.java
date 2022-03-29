package com.example.purchasepage.mapper;

import com.example.purchasepage.pojo.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {
        @Options(useGeneratedKeys=true,keyProperty="id") //主键自增
        @Insert("insert into company_info(name) values (#{name})")
        void addCompany(Company company);

        @Update("update company_info set name=#{name} where id=#{id}")
        void updateCompany(Company company);

        @Select("select id,name from company_info where id=#{id}")
        Company getCompanyById(Integer id);

        @Delete("delete from company_info where id=#{id}")
        void deleteCompany(Integer id);

        @Select("select * from company_info")
        List<Company> getAllCompanies();
}
