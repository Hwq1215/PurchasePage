package com.example.purchasepage.pojo;

import com.example.purchasepage.config.DateConverterConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealingProject {
    private Integer id;         //项目编号
    private Integer lowPrice,highPrice; //价格
    private Integer amount;     //处理量
    private Integer userId;     //发布用户的id
    private Integer publish;    //发布的标志量
    private String imgPath;     //图片文件路径
    private String port;        //端口
    private String type;        //种类
    private String name;        //项目的名字
    private String demand;      //需求
    private String introduce;   //项目的内容
    private String location;    //项目的地域
    private Integer ripe;        //成熟度
    private String time ;       //项目开始时间
    private String tag1;         //标签1
    private String tag2;         //标签2
    private String tag3;         //标志3

    public DealingProject(Integer lowPrice, Integer highPrice,Integer amount,Integer userId,String imgPath,String port, String type, String name, String demand, String introduce, String location, Integer ripe, String tag1,String tag2,String tag3) {
        this.id = 1;
        this.publish = 0;
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
        this.amount = amount;
        this.userId = userId;
        this.imgPath = imgPath;
        this.port = port;
        this.type = type;
        this.name = name;
        this.demand = demand;
        this.introduce = introduce;
        this.location = location;
        this.time = new DateConverterConfig().DataFormat(new Date());
        this.ripe = ripe;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Integer lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Integer getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Integer highPrice) {
        this.highPrice = highPrice;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRipe() {
        return ripe;
    }

    public void setRipe(Integer ripe) {
        this.ripe = ripe;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTag() {
        return tag1;
    }

    public void setTag(String tag) {
        this.tag1 = tag;
    }


}
