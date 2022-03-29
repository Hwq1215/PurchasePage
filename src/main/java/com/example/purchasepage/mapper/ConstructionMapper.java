package com.example.purchasepage.mapper;

import com.example.purchasepage.pojo.Construction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ConstructionMapper {
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into construction_info(name,phone,email,message) " +
            "values (#{name},#{phone},#{email},#{message})")
    public void addConstruction(Construction construction);

}
