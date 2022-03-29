package com.example.purchasepage.controller;

import com.example.purchasepage.pojo.Order;
import com.example.purchasepage.pojo.RetResult;
import com.example.purchasepage.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("order")
public class OrderController {
    OrderService orderService;

    @GetMapping("list")
    public RetResult listOrders(){
        List<Order> orders = orderService.getAllOrders();
        if(orders == null){
            return new RetResult(404,"success",null);
        }
        return new RetResult(200,"fail:",orders);
    }

    @GetMapping("/searchOrder/{id}")
    public RetResult getOrderById(@PathVariable("id")Integer id){
        RetResult result;
        if(orderService.getOrderById(id) == null){
            result = new RetResult(404,"no exist the company",null);
            return result;
        }
        result = new RetResult(200,"search successfully",orderService.getOrderById(id));
        return result;
    }

    @PostMapping("/add")
    public RetResult addOrder(Order order){
        if(orderService.addOrder(order)){
            return new RetResult(200,"add successfully", orderService.getAllOrders());
        }
        return new RetResult(404,"add failed",orderService.getAllOrders());
    }

    @PostMapping("/update")
    public RetResult updateOrder(Order order){
        RetResult result;
        if(orderService.updateOrder(order)==false){
            return new RetResult(404,"updated failed",orderService.getAllOrders());
        }
        return new RetResult(200,"success",orderService.getAllOrders());
    }

    @GetMapping("delete/{id}")
    public  RetResult delOrder(@PathVariable("id") Integer id){
        if(orderService.deleteOrder(id) == false){
            return new RetResult(404,"delete failed",null);
        }
        return  new RetResult(200,"success",orderService.getAllOrders());
    }
}
