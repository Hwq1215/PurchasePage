package com.example.purchasepage.service;

import com.example.purchasepage.mapper.OrderMapper;
import com.example.purchasepage.pojo.Company;
import com.example.purchasepage.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public boolean addOrder(Order order){
        if(orderMapper.getOrderById(order.getOrderId())==null){
            orderMapper.addOrder(order);
            return true;
        }
        return false;
    }

    public boolean updateOrder(Order order){
        boolean flag = false;
        if(order == null){
            return false;
        }
        orderMapper.updateOrder(order);
        return true;
    }

    public List<Order> getAllOrders(){
        List<Order> orders = orderMapper.getAllOrders();
        return orders;
    }

    public Order getOrderById(Integer id){
        return orderMapper.getOrderById(id);
    }

    public Boolean deleteOrder(Integer id){
        if(orderMapper.getOrderById(id) == null){
            return false;
        }
        orderMapper.deleteOrder(id);
        return true;
    }
}
