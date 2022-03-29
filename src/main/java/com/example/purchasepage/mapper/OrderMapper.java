package com.example.purchasepage.mapper;

import com.example.purchasepage.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Options(useGeneratedKeys = true,keyProperty = "orderId")
    @Insert("insert into order_info(companyId,projectId,orderTime) values (#{companyId},#{projectId},#{orderTime})")
    void addOrder(Order order);

    @Update("update order_info set companyId=#{companyId} projectId=#{projectId} orderTime=#{orderTime} where orderId=#{orderId}")
    void updateOrder(Order order);

    @Select("select * from order_info where orderId=#{orderId}")
    Order getOrderById(Integer id);

    @Delete("delete from order_info where orderId=#{orderId}")
    void deleteOrder(Integer id);

    @Select("select * from order_info")
    List<Order> getAllOrders();
}
