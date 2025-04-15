package com.example.feignservice.feign;

import com.example.feignservice.dto.PmsCategoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "GuliMallPms")
@RequestMapping("/pmscategory")
public interface PmsCategoryFeignService {

    @GetMapping("/treelistone")
    public List<PmsCategoryDto> getTreeList1();
}
