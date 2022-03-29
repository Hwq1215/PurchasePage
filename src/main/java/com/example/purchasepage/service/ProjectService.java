package com.example.purchasepage.service;

import com.example.purchasepage.component.SortListUtil;
import com.example.purchasepage.mapper.ProjectMapper;
import com.example.purchasepage.pojo.DealingProject;
import com.example.purchasepage.pojo.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    SortListUtil<DealingProject> projectSortList = new SortListUtil<DealingProject>();

    @Autowired
    ProjectMapper projectMapper;

    List<DealingProject> tempProjects;

       //缓存数据

    public boolean addProject(DealingProject dealingProject){
            projectMapper.addProject(dealingProject);
            return true;
    }

    public boolean updateProject(DealingProject dealingProject){
        boolean flag = false;
        if(dealingProject == null){
            return false;
        }
        projectMapper.updateProject(dealingProject);
        return true;
    }

    public List<DealingProject> getAllProjects(){
        List<DealingProject> projects;
        projects = projectMapper.getAllProjectsDefault();
        tempProjects = projects;
        return projects;
    }

    public DealingProject getProjectById(Integer id){
        return projectMapper.getProjectById(id);
    }

    public List<DealingProject> getProjectByType(String type){
        List<DealingProject> projects;
        projects = projectMapper.getProjectsByType(type);
        return projects;
    }

    public List<DealingProject> getProjectByLocation(String location){
        List<DealingProject> projects;
        projects = projectMapper.getProjectByLocation(location);
        return projects;
    }

    public List<DealingProject> getProjectByKeyword(String keyword){
        List<DealingProject> projects;
        projects = projectMapper.getProjectByKeyword(keyword);
        tempProjects = projects;
        return projects;
    }

    public List<DealingProject> getProjectsByKeywordByLocation(String keyword,String location){
        List<DealingProject> projects;
        projects = projectMapper.getProjectByKeywordByLocation(keyword,location);
        tempProjects = projects;
        return projects;
    }

    public List<DealingProject> getProjectsByPrice(Integer lowPrice,Integer highPrice){
        List<DealingProject> projects;
        projects = projectMapper.getProjectByPrice(lowPrice,highPrice);
        return projects;
    }

    public List<DealingProject> getProjectsByKeywordByPrice(String keyword,Integer lowPrice,Integer highPrice){
        List<DealingProject> projects;
        projects = projectMapper.getProjectByKeywordByPrice(keyword,lowPrice,highPrice);
        return projects;
    }

    public List<DealingProject> getProjectsByLocationByPrice(String location,Integer lowPrice,Integer highPrice){
        List<DealingProject> projects;
        projects = projectMapper.getProjectByLocationByPrice(location,lowPrice,highPrice);
        return projects;
    }

    public List<DealingProject> getProjectsByKeywordByLocationByPrice(String keyword,String location,Integer lowPrice,Integer highPrice){
        List<DealingProject> projects;
        if(keyword.equalsIgnoreCase("default")){
            if(location.equalsIgnoreCase("default")){
                projects = getProjectsByPrice(lowPrice,highPrice);
            }else{
                projects = getProjectsByLocationByPrice(location,lowPrice,highPrice);
            }
        }else if(location.equals("default")){
                projects = getProjectsByKeywordByPrice(keyword,lowPrice,highPrice);
        }else{
                projects = projectMapper.getProjectByKeywordByLocationByPrice(keyword,location,lowPrice,highPrice);
        }
        tempProjects = projects;
        System.out.println("search success");
        return projects;
    }

    public  List<DealingProject> getProjectByUserId(Integer userId){
        List<DealingProject> projects;
        projects = projectMapper.getProjectByUserId(userId);
        return projects;
    }

    public Boolean deleteProject(Integer id){
        if(projectMapper.getProjectById((id)) == null){
            return false;
        }
        projectMapper.deleteProject(id);
        return true;
    }

    //把刚才临时访问的按一定顺序排序
    public List<DealingProject> getTempProjectsInPriceOrder(Boolean ifUp){
        if(ifUp == true){
            projectSortList.Sort(tempProjects,"getLowPrice",null);
        }else{
            projectSortList.Sort(tempProjects,"getLowPrice","desc");
        }
        return tempProjects;
    }

    public List<DealingProject> getTempProjectsInTimeOrder(Boolean ifUp){
        if(ifUp == true){
            projectSortList.Sort(tempProjects,"getTime",null);
        }else{
            projectSortList.Sort(tempProjects,"getTime","desc");
        }
        return tempProjects;
    }


}
