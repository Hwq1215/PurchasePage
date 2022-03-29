package com.example.purchasepage.mapper;

import com.example.purchasepage.pojo.IndexPolicy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IndexContentMapper {

    @Select("select * from policy_info")
    public List<IndexPolicy> getPolicy();

}
