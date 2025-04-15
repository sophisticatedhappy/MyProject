package com.example.gulimallpms.transfer;

import com.example.gulimallpms.CatLevelEnum;
import com.example.gulimallpms.entity.PmsCategory;
import com.example.gulimallpms.mapper.PmsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParentCid2PmsCategory {

    @Autowired
    private PmsCategoryMapper pmsCategoryMapper;

    public Map<Integer, List<PmsCategory>> getCategoryMap(){
        List<PmsCategory> firstLevel = pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_1.getLevel());
        List<PmsCategory> secondLevel = pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_2.getLevel());
        List<PmsCategory> thirdLevel = pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_3.getLevel());


        for(PmsCategory pmsCategory : firstLevel){
            System.out.println(pmsCategory);
        }

        Map<Integer, PmsCategory> collect = firstLevel.stream().collect(Collectors.toMap(PmsCategory::getParentCid, Function.identity(), (o1, o2) -> o1));
        for(Map.Entry<Integer,PmsCategory> entry : collect.entrySet()){
            System.out.println("key:"+entry.getKey()+"->"+"value:"+entry.getValue());
        }

        Map<Integer, List<PmsCategory>> map = new HashMap<>();
        return map;
    }

}
