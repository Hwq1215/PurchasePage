package com.example.purchasepage.service;

import com.example.purchasepage.mapper.CollectionMapper;
import com.example.purchasepage.mapper.ProjectMapper;
import com.example.purchasepage.pojo.Collection;
import com.example.purchasepage.pojo.DealingProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {

    @Autowired
    CollectionMapper collectionMapper;

    @Autowired
    ProjectMapper projectMapper;

    public boolean addCollection(Collection collection){
        if(collectionMapper.searchCollectionByAll(collection.getUserId(),collection.getProjectId())!=null){
            return false;
        }
        collectionMapper.addCollection(collection);
        System.out.println("collect success:"+collection.toString());
        return true;
    }

    public List<DealingProject> searchCollections(Integer userId){
        List<Collection> collections;
        collections = collectionMapper.searchCollectionByUserId(userId);
        List<DealingProject> projects = new ArrayList<>();
        for(int index = 0;index<collections.size();index++){
            Collection collection = collections.get(index);
            projects.add(projectMapper.getProjectById(collection.getProjectId()));
        }
        return projects;
    }


    public boolean deleteCollection(Integer userId,Integer projectId){
        if(collectionMapper.searchCollectionByAll(userId,projectId)==null){
            return false;
        }
        collectionMapper.delCollection(userId,projectId);
        return true;
    }
}

