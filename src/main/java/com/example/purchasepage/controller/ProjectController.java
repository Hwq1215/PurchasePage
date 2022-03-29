package com.example.purchasepage.controller;

import com.example.purchasepage.pojo.DealingProject;
import com.example.purchasepage.pojo.RetResult;
import com.example.purchasepage.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.example.purchasepage.component.FileUtils.ProjectImgPath;
import static com.example.purchasepage.component.FileUtils.upLoadFile;


@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    ProjectService projectService = new ProjectService();
    private static  String defaultPic = ProjectImgPath +"default.jpg";
    @CrossOrigin
    @PostMapping("/add")
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
                                @RequestParam(value = "tag3",required = false,defaultValue = "default") String tag3)throws IOException {
        String imgPath = upLoadFile(img);
        DealingProject dealingProject = new DealingProject(lowPrice,highPrice,amount,userId,imgPath,port,type,name,demand,introduce,location,ripe,tag1,tag2,tag3);
        if(projectService.addProject(dealingProject)==true){
            return new RetResult(200,"success",null);
        }
        return new RetResult(404,"fail",null);
    }

    @CrossOrigin
    @GetMapping("/list")
    public RetResult getAllProjects(){
        List<DealingProject> projects = projectService.getAllProjects();
        if(projects == null){
            return new RetResult(404,"fail:no data",null);
        }
        return new RetResult(200,"success",projects);
    }

    @CrossOrigin
    @GetMapping("/search/{id}")
    public RetResult getProjectById(@PathVariable("id")Integer id){
        DealingProject dealingProject = projectService.getProjectById(id);
        if(dealingProject== null){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"fail",dealingProject);
    }

    @CrossOrigin
    @PostMapping("/delete/{id}")
    public RetResult delProject(@PathVariable("id")Integer id){
        if(projectService.deleteProject(id) == false){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projectService.getAllProjects());
    }

    @CrossOrigin
    @GetMapping("update")
    public RetResult updateProject(DealingProject dealingProject){
        if(projectService.updateProject(dealingProject)==false){
            return new RetResult(404,"fail:no exist",null);
        }
        return new RetResult(200,"success",projectService.getAllProjects());
    }
}
