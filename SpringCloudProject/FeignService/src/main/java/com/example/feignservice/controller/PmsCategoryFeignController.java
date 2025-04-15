package com.example.feignservice.controller;

import com.example.feignservice.dto.PmsCategoryDto;
import com.example.feignservice.feign.PmsCategoryFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class PmsCategoryFeignController {

    @Autowired
    private PmsCategoryFeignService pmsCategoryFeignService;

    @GetMapping("/getData")
    public List<PmsCategoryDto> getData(){
        List<PmsCategoryDto> treeList1 = pmsCategoryFeignService.getTreeList1();
        return treeList1;
    }
}
