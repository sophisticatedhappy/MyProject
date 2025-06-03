package com.example.gulimalladmin.service;

import com.example.gulimalladmin.entity.Menu;
import com.example.gulimalladmin.entity.MenuPage;

import java.util.List;

public interface MenuService {
    List<Menu> selectAll();

    List<Menu> getByPage(MenuPage menuPage);
}
