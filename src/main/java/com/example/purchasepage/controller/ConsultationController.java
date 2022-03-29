package com.example.purchasepage.controller;

import com.example.purchasepage.pojo.Construction;
import com.example.purchasepage.pojo.RetResult;
import com.example.purchasepage.service.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class ConsultationController {
    @Autowired
    ConstructionService constructionService = new ConstructionService();

    @ResponseBody
    @PostMapping("consult")
    public RetResult leave(Construction construction){
        if(constructionService.addConstruction(construction) == true){
            return new RetResult(200);
        }
        return new RetResult(404);
    }

    @RequestMapping("addConsult")
    public String addConsult(){
        return "addConsult.html";
    }
}
