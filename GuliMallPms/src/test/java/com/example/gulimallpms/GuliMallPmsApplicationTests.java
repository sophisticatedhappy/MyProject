package com.example.gulimallpms;

import com.example.gulimallpms.dto.PmsCategoryDto;
import com.example.gulimallpms.entity.PmsCategory;
import com.example.gulimallpms.mapper.PmsCategoryMapper;
import com.example.gulimallpms.service.PmsCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SpringBootTest
class GuliMallPmsApplicationTests {


    @Autowired
    private PmsCategoryMapper pmsCategoryMapper;

    @Autowired
    private PmsCategoryService pmsCategoryService;
    @Test
    void contextLoads() {
        List<PmsCategory> pmsCategories = pmsCategoryMapper.selectByCatLevel(1);
        pmsCategories.stream()
                .filter(pmsCategory -> pmsCategory.showStatus == 1)
                .forEach(pmsCategory ->
                System.out.println(pmsCategory));
    }

    @Test
    void test1(){
        List<PmsCategoryDto> pmsCategoryDtos = pmsCategoryService.selectAllCategorys();
        System.out.println(pmsCategoryDtos.size());
    }

    @Test
    void test2(){
        List<PmsCategoryDto> pmsCategoryDtos = pmsCategoryService.selectAllCategorys();
        pmsCategoryDtos.stream().forEach(pmsCategoryDto ->
                System.out.println(pmsCategoryDto)
        );
    }

    @Test
    void test3(){
        List<PmsCategory> list = new ArrayList<>();

        Map<Integer, PmsCategory> collect = list.
                stream().
                collect(Collectors.toMap(PmsCategory::getParentCid, Function.identity(), (o1, o2) -> o1));

    }

    @Test
    void test4(){
        List<PmsCategory> firstLevel = pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_1.getLevel());
        List<PmsCategory> secondLevel = pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_2.getLevel());
        List<PmsCategory> thirdLevel = pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_3.getLevel());


        for(PmsCategory pmsCategory : firstLevel){
            System.out.println(pmsCategory);
        }

        Map<Integer, PmsCategory> collect = firstLevel.stream().collect(Collectors.toMap(PmsCategory::getParentCid, Function.identity(), (o1, o2) -> o2));
        for(Map.Entry<Integer,PmsCategory> entry : collect.entrySet()){
            System.out.println("key:"+entry.getKey()+"->"+"value:"+entry.getValue());
        }

        System.out.println("=======================================");
        Map<Integer, List<PmsCategory>> collect1 = firstLevel.stream().collect(Collectors.groupingBy(PmsCategory::getParentCid));
        for(Map.Entry<Integer,List<PmsCategory>> entry: collect1.entrySet()){
            System.out.println("key值为: "+ entry.getKey() + "value如下:");
            for(PmsCategory pmsCategory : entry.getValue()){
//                System.out.println("value如下:");
                System.out.println(pmsCategory);
            }
        }

    }

}
