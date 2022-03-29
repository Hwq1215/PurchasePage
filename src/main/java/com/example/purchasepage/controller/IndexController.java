package com.example.purchasepage.controller;

import com.example.purchasepage.pojo.IndexPolicy;
import com.example.purchasepage.pojo.RetResult;
import com.example.purchasepage.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("index")
public class IndexController {
    @Autowired
    IndexService indexService = new IndexService();

    @GetMapping("/policy")
    public RetResult getPolicy(){
        List<IndexPolicy> polices = indexService.getIndexPolicy();
        if(polices==null){
            return new RetResult(404,"no exist",null);
        }
        return new RetResult(200,"success",polices);
    }
}
