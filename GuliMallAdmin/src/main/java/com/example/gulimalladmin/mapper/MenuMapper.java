package com.example.gulimalladmin.mapper;


import com.example.gulimalladmin.entity.Menu;
import com.example.gulimalladmin.entity.MenuPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MenuMapper {
    List<Menu> selectAll();

    List<Menu> getByPage(@Param("menuPage") MenuPage menuPage);
}
