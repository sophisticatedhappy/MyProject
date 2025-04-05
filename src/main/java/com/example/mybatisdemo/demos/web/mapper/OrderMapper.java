package com.example.mybatisdemo.demos.web.mapper;

import com.example.mybatisdemo.demos.web.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {


    List<Order> selectAll();

    void batchSave(@Param("orders") List<Order> orders);

}
