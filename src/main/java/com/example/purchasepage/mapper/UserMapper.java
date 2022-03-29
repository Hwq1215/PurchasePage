package com.example.purchasepage.mapper;

import com.example.purchasepage.pojo.DealingProject;
import com.example.purchasepage.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user_info where userId=#{userId} and password=#{password}")
    User searchUserByAll(Integer userId,String password);

    @Select("select * from user_info where userId=#{userId}")
    User searchUserById(Integer userId);
}
