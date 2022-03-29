package com.example.purchasepage.mapper;

import com.example.purchasepage.pojo.DealingProject;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into project_info(lowPrice,highPrice,amount,userId,imgPath,port,type,name,demand,introduce,location,ripe,time,tag1,tag2,tag3) " +
            "values (#{lowPrice},#{highPrice},#{amount},#{userId},#{imgPath},#{port},#{type},#{name},#{demand},#{introduce},#{location},#{ripe},#{time},#{tag1},#{tag2},#{tag3})")
    void addProject(DealingProject p);

    @Update("update project_info set lowPrice=#{lowPrice},highPrice=#{highPrice},userId=#{userId},amount=#{amount},imgPath=#{imgPath},port=#{port},type=#{type},name=#{name},demand=#{demand}" +
            "introduce=#{introduce},location=#{location},ripe=#{ripe},time=#{time},tag1=#{tag1},tag2=#{tag2},tag3=#{tag3} where id=#{id}")
    void updateProject(DealingProject d);

    @Select("select * from project_info where id=#{id}")
    DealingProject getProjectById(Integer id);

    @Delete("delete from project_info where id=#{id}")
    void deleteProject(Integer id);

    @Select("select * from project_info where type=#{type} and publish=1")
    List<DealingProject> getProjectsByType(String type);

    @Select("select * from project_info where location=#{location} and publish=1")
    List<DealingProject> getProjectByLocation(String location);

    @Select("select * from project_info where " +
            "publish=1 and " +
            "(name like concat('%',#{keyword},'%') or " +
            "location like concat('%',#{keyword},'%') or " +
            "type like concat('%',#{keyword},'%') or " +
            "tag1 like concat('%',#{keyword},'%') or " +
            "tag2 like concat('%',#{keyword},'%') or " +
            "tag3 like concat('%',#{keyword},'%'))")
    List<DealingProject> getProjectByKeyword(String keyword);

    @Select("select * from project_info where lowPrice >= #{lowPrice} and highPrice <= #{highPrice} and publish=1")
    List<DealingProject> getProjectByPrice(Integer lowPrice,Integer highPrice);

    @Select("select * from project_info where " +
            "publish=1 and " +
            "location=#{location} and " +
            "(name like concat('%',#{keyword},'%') or " +
            "type like concat('%',#{keyword},'%') or " +
            "tag1 like concat('%',#{keyword},'%') or " +
            "tag2 like concat('%',#{keyword},'%') or " +
            "tag3 like concat('%',#{keyword},'%'))")
    List<DealingProject> getProjectByKeywordByLocation(String keyword,String location);

    @Select("select * from project_info where " +
            "publish=1 and " +
            "lowPrice >= #{lowPrice} and highPrice <= #{highPrice} and"+
            "(name like concat('%',#{keyword},'%') or " +
            "location like concat('%',#{keyword},'%') or " +
            "type like concat('%',#{keyword},'%') or " +
            "tag1 like concat('%',#{keyword},'%') or " +
            "tag2 like concat('%',#{keyword},'%') or " +
            "tag3 like concat('%',#{keyword},'%'))")
    List<DealingProject> getProjectByKeywordByPrice(String keyword,Integer lowPrice,Integer highPrice);

    @Select("select * from project_info where " +
            "publish=1 and " +
            "location=#{location} and " +
            "lowPrice >= #{lowPrice} and highPrice <= #{highPrice}")
    List<DealingProject> getProjectByLocationByPrice(String location,Integer lowPrice,Integer highPrice);

    @Select("select * from project_info where " +
            "publish=1 and " +
            "location=#{location} and " +
            "lowPrice >= #{lowPrice} and highPrice <= #{highPrice} and"+
            "(name like concat('%',#{keyword},'%') or " +
            "location like concat('%',#{keyword},'%') or " +
            "type like concat('%',#{keyword},'%') or " +
            "tag1 like concat('%',#{keyword},'%') or " +
            "tag2 like concat('%',#{keyword},'%') or " +
            "tag3 like concat('%',#{keyword},'%'))")
    List<DealingProject> getProjectByKeywordByLocationByPrice(String keyword,String location,Integer lowPrice,Integer highPrice);

    @Select("select * from project_info where publish=1")
    List<DealingProject> getAllProjectsDefault();

    @Select("select * from project_info where userId=#{userId}")
    List<DealingProject> getProjectByUserId(Integer userId);
}
