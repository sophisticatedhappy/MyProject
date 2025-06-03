package com.example.gulimalladmin.service.impl;

import com.example.gulimalladmin.entity.Menu;
import com.example.gulimalladmin.entity.MenuPage;
import com.example.gulimalladmin.mapper.MenuMapper;
import com.example.gulimalladmin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectAll() {
        return null;
    }

    @Override
    public List<Menu> getByPage(MenuPage menuPage) {
        return menuMapper.getByPage(menuPage);
    }


}
