package com.example.purchasepage;

import com.example.purchasepage.mapper.CompanyMapper;
import com.example.purchasepage.mapper.ProjectMapper;
import com.example.purchasepage.pojo.RetResult;
import com.example.purchasepage.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
class PurchasePageApplicationTests {
    @Autowired
    private ProjectService projectService = new ProjectService();

    @Test
    void contextLoads() {

    }

}
