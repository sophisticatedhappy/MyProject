package com.example.gulimallpms.controller;

import com.example.gulimallpms.dto.PmsCategoryDto;
import com.example.gulimallpms.service.PmsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pmscategory")
public class PmsCategoryController {

    @Autowired
    private PmsCategoryService pmsCategoryService;

    @GetMapping(value = "/treelist")
    public List<PmsCategoryDto> getTreeList() {
        List<PmsCategoryDto> pmsCategoryDtos = pmsCategoryService.selectAllCategorys();
        return pmsCategoryDtos;
    }

    @GetMapping("/treelistone")
    public List<PmsCategoryDto> getTreeList1() {
        List<PmsCategoryDto> pmsCategoryDtos = pmsCategoryService.selectAllCategorys1();
        return pmsCategoryDtos;
    }
}
