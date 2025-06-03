package com.example.gulimalladmin.controller;

import com.example.gulimalladmin.entity.Menu;
import com.example.gulimalladmin.entity.MenuPage;
import com.example.gulimalladmin.mapper.MenuMapper;
import com.example.gulimalladmin.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuServiceImpl menuService;

    @GetMapping("/selectAll")
    public List<Menu> selectAll(){
        List<Menu> menus = menuMapper.selectAll();
        return menus;
    }

    @PostMapping("/getByPage")
    public List<Menu> getByPage(@RequestBody MenuPage menuPage){
        return menuService.getByPage(menuPage);
    }
}
