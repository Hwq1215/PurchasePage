package com.example.purchasepage.mapper;

import com.example.purchasepage.pojo.Collection;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollectionMapper {
    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert collection_info(userId,projectId) values (#{userId},#{projectId}) ")
    void addCollection(Collection collection);

    @Select("select * from collection_info where userId=#{userId}")
    List<Collection> searchCollectionByUserId(Integer userId);

    @Delete("delete from collection_info where userId=#{userId} and projectId=#{projectId}")
    void delCollection(Integer userId,Integer projectId);

    @Select("select * from collection_info where userId=#{userId} and projectId=#{projectId}")
    Collection searchCollectionByAll(Integer userId, Integer projectId);
}
