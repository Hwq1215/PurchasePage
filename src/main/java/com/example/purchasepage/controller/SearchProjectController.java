package com.example.purchasepage.controller;

import com.example.purchasepage.pojo.DealingProject;
import com.example.purchasepage.pojo.RetResult;
import com.example.purchasepage.service.ProjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("searchProject")
@CrossOrigin
public class SearchProjectController {
    @Autowired
    ProjectService projectService = new ProjectService();

    @CrossOrigin
    @GetMapping("/byId")
    public RetResult getProjectById(@RequestParam("id") Integer id){
        DealingProject dealingProject = projectService.getProjectById(id);
        if(dealingProject== null){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",dealingProject);
    }

    @CrossOrigin
    @GetMapping("/all")
    public RetResult getAllProjects(){
        List<DealingProject> projects = projectService.getAllProjects();
        if(projects.isEmpty()){
            return new RetResult(404,"fail:no data",null);
        }
        return new RetResult(200,"success",projects);
    }

    @CrossOrigin
    @GetMapping("/byType/{type}")
    public RetResult getProjectByType(@PathVariable("type") String type){
        List<DealingProject> projects = projectService.getProjectByType(type);
        if(projects.isEmpty()){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projects);
    }

    @CrossOrigin
    @GetMapping("/byLocation/{location}")
    public RetResult getProjectsByLocation(@PathVariable("location") String location){
        List<DealingProject> projects = projectService.getProjectByLocation(location);
        if(projects.isEmpty()){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projects);
    }

    @CrossOrigin
    @GetMapping("/byKeyword/{keyword}")
    public RetResult getProjectsByKeyword(@PathVariable("keyword") String keyword){
        List<DealingProject> projects = projectService.getProjectByKeyword(keyword);
        if(projects.isEmpty()){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projects);
    }

    @CrossOrigin
    @GetMapping("/byKeywordByLocation/{keyword}/{location}")
    public RetResult getProjectsByKeywordByLocation(@PathVariable("keyword") String keyword, @PathVariable("location") String location){
        List<DealingProject> projects = projectService.getProjectsByKeywordByLocation(keyword,location);
        if(projects.isEmpty()){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projects);
    }

    @CrossOrigin
    @GetMapping("/byUserId")
    public RetResult getProjectByUserId(@RequestParam Integer userId){
        List<DealingProject> projects = projectService.getProjectByUserId(userId);
        if(projects.isEmpty()){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projects);
    }

    @CrossOrigin
    @PostMapping("/byKeywordByLocationByPrice")
    public RetResult getProjectsByKeywordByLocationByPrice(@RequestParam(value = "keyword",required = false,defaultValue = "default") String keyword,
                                                           @RequestParam(value = "location",required = false,defaultValue = "default") String location,
                                                           @RequestParam(value = "lowPrice",required = false,defaultValue = "-1") Integer lowPrice,
                                                           @RequestParam(value = "highPrice",required = false,defaultValue = "1000000000") Integer highPrice
                                                            ){
        List<DealingProject> projects;
        //全都为空，返回错误
        if( keyword.equalsIgnoreCase("default") &&
                location.equalsIgnoreCase("default") &&
                lowPrice==-1&&highPrice==1000000000){
            return new RetResult(404,"fail:post request all null",null);
            //数字为空 返回错误
        }else if(lowPrice >= highPrice){
            return new RetResult(404,"price error",null);
        }
        projects = projectService.getProjectsByKeywordByLocationByPrice(keyword,location,lowPrice,highPrice);
        if(projects.isEmpty()){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projects);
    }

    @CrossOrigin
    @GetMapping(value = {"/order/price","/order/price/asc"})
    public RetResult getTempProjectsByPriceASC(){
        List<DealingProject> projects = projectService.getTempProjectsInPriceOrder(true);
        if(projects.isEmpty()){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projects);
    }

    @CrossOrigin
    @GetMapping("/order/price/dec")
    public RetResult getTempProjectsByPriceDEC(){
        List<DealingProject> projects = projectService.getTempProjectsInPriceOrder(false);
        if(projects.isEmpty()){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projects);
    }

    @CrossOrigin
    @GetMapping(value = {"/order/time/asc","order/time"})
    public RetResult getTempProjectsByTimeASC(){
        List<DealingProject> projects = projectService.getTempProjectsInTimeOrder(true);
        if(projects.isEmpty()){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projects);
    }

    @CrossOrigin
    @GetMapping("/order/time/dec")
    public RetResult getTempProjectsByTimeDEC(){
        List<DealingProject> projects = projectService.getTempProjectsInTimeOrder(false);
        if(projects.isEmpty()){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projects);
    }


}
