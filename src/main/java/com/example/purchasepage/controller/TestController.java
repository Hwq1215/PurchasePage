package com.example.purchasepage.controller;

import com.example.purchasepage.mapper.ProjectMapper;
import com.example.purchasepage.pojo.DealingProject;
import com.example.purchasepage.pojo.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller

public class TestController {
    @Autowired
    ProjectMapper projectMapper;

    @GetMapping("/record")
    public String changesPage(){
        return "changes.html";
    }

    @GetMapping("/api")
    public String apiPage(){
        return "API.html";
    }

    @GetMapping("/addPage")
    public String addPage() {
        return "addPage.html";
    }

    @GetMapping("search/price/{lowPrice}/{highPrice}")
    @ResponseBody
    public RetResult searchPage(@PathVariable("lowPrice") Integer lowPrice,@PathVariable("highPrice") Integer highPrice){
        RetResult result;
        List<DealingProject> projects = projectMapper.getProjectByPrice(lowPrice,highPrice);
        return new RetResult(200,"success",projects);
    }

    @GetMapping("searchPage")
    public String searchPage(){ return "searchPage.html"; }
}
