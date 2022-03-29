package com.example.purchasepage.service;

import com.example.purchasepage.mapper.IndexContentMapper;
import com.example.purchasepage.pojo.IndexPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    @Autowired
    IndexContentMapper indexContentMapper;

    public List<IndexPolicy> getIndexPolicy(){
        return indexContentMapper.getPolicy();
    }
}
