package com.example.purchasepage.controller;

import com.example.purchasepage.pojo.Collection;
import com.example.purchasepage.pojo.DealingProject;
import com.example.purchasepage.pojo.RetResult;
import com.example.purchasepage.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("collect")
public class CollectionController {

    @Autowired
    CollectionService collectionService = new CollectionService();


    @GetMapping("/new")
    public RetResult addCollection(
                                   @RequestParam("userId") Integer userId,
                                   @RequestParam("projectId") Integer projectId){
        Integer id = 1000000;
        if(collectionService.addCollection(new Collection(id,userId,projectId))==true){
            return new RetResult<>(200);
        }
        return new RetResult(404,"had exist",null);
    }

    @CrossOrigin
    @GetMapping("")
    public RetResult searchCollections(@RequestParam("userId") Integer userId){
        List<DealingProject> projects = collectionService.searchCollections(userId);
        return new RetResult<List<DealingProject>>(200,"success",projects);
    }

    @GetMapping("/delete")
    public RetResult deleteCollection(@RequestParam("userId") Integer userId,@RequestParam("projectId") Integer projectId){
        if(collectionService.deleteCollection(userId, projectId)==true){
            return new RetResult<>(200);
        }
        return new RetResult(404,"no exist",null);
    }
}
