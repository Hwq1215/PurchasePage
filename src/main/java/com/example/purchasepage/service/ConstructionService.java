package com.example.purchasepage.service;

import com.example.purchasepage.mapper.ConstructionMapper;
import com.example.purchasepage.pojo.Construction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstructionService {
    @Autowired
    ConstructionMapper constructionMapper;
    public boolean addConstruction(Construction construction){
        if(construction == null){
            return false;
        }
        constructionMapper.addConstruction(construction);
        return true;
    }
}
