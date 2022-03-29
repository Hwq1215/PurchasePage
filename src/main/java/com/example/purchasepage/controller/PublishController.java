package com.example.purchasepage.controller;

import com.example.purchasepage.pojo.DealingProject;
import com.example.purchasepage.pojo.RetResult;
import com.example.purchasepage.service.ProjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.example.purchasepage.component.FileUtils.upLoadFile;

@RestController
@CrossOrigin
public class PublishController {
    @Autowired
    ProjectService projectService = new ProjectService();

    @CrossOrigin
    @PostMapping("publish/ifSend")
    public RetResult judge(@Param("publish") Boolean flag){
        if(flag==true) return new RetResult(200);
        return new RetResult<>(404);
    }

    @CrossOrigin
    @GetMapping("publish/step")  //no finish
    public RetResult stepIs(){
        return new RetResult(500,"success",new Integer(1));
    }

    @CrossOrigin
    @PostMapping("publish/summit")
    public RetResult addProject(//@Param("id")Integer id,
                                @RequestParam("lowPrice") Integer lowPrice,
                                @RequestParam("highPrice") Integer highPrice,
                                @RequestParam("amount") Integer amount,
                                @RequestParam("userId") Integer userId,
                                @RequestParam(value = "img",required = false) MultipartFile img,
                                @RequestParam("port") String port,
                                @RequestParam("type") String type,
                                @RequestParam("name") String name,
                                @RequestParam("demand") String demand,
                                @RequestParam("introduce") String introduce,
                                @RequestParam("location") String location,
                                @RequestParam("ripe") Integer ripe,
                                @RequestParam(value = "tag1",required = false,defaultValue = "default") String tag1,
                                @RequestParam(value = "tag2",required = false,defaultValue = "default") String tag2,
                                @RequestParam(value = "tag3",required = false,defaultValue = "default") String tag3) throws IOException {
        System.out.println(img.getName());
        String imgPath = upLoadFile(img);
        DealingProject dealingProject = new DealingProject(lowPrice,highPrice,amount,userId,imgPath,port,type,name,demand,introduce,location,ripe,tag1,tag2,tag3);
        if(projectService.addProject(dealingProject)==true){
            return new RetResult(200,"success",null);
        }
        return new RetResult(404,"fail",null);
    }
}


