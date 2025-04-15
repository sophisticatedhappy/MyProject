package com.example.gulimallpms.service.impl;

import com.example.gulimallpms.CatLevelEnum;
import com.example.gulimallpms.dto.PmsCategoryDto;
import com.example.gulimallpms.entity.PmsCategory;
import com.example.gulimallpms.mapper.PmsCategoryMapper;
import com.example.gulimallpms.service.PmsCategoryService;
import com.example.gulimallpms.transfer.PmsCategoryToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PmsCategoryServiceImpl implements PmsCategoryService {

    @Autowired
    private PmsCategoryMapper pmsCategoryMapper;

    @Override
    public List<PmsCategoryDto> selectAllCategorys() {


        List<List<PmsCategory>> list = new ArrayList<>();
        list.add(pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_1.getLevel()));
        list.add(pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_2.getLevel()));
        list.add(pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_3.getLevel()));

        List<PmsCategoryDto> firstLevel = new ArrayList<>();
        List<PmsCategoryDto> secondLevel = new ArrayList<>();
        List<PmsCategoryDto> thirdLevel = new ArrayList<>();


        //装填第三级菜单
        list.get(2).stream().forEach(
                pmsCategory -> {
                    thirdLevel.add(PmsCategoryToDto.PmsCategory2PmsCategoryToDto(pmsCategory,new ArrayList<>()));
                }
        );
        //装填第二级菜单
        list.get(1).stream().forEach(
                pmsCategory -> {
                    secondLevel.add((PmsCategoryToDto.PmsCategory2PmsCategoryToDto(pmsCategory,new ArrayList<>())));
                }
        );

        secondLevel.stream().forEach(
                pmsCategoryDto -> {
                    List<PmsCategoryDto> templist = thirdLevel.stream().filter(
                            pmsCategoryDto1 -> {
                                return pmsCategoryDto1.getParentCid() == pmsCategoryDto.getCatId();
                            }
                    ).collect(Collectors.toList());
                    pmsCategoryDto.setSubCategoryList(templist);
                }
        );

        //装填第一级菜单
        list.get(0).stream().forEach(
                pmsCategory -> {
                    firstLevel.add(PmsCategoryToDto.PmsCategory2PmsCategoryToDto(pmsCategory,new ArrayList<>()));
                }
        );

        firstLevel.stream().forEach(
                pmsCategoryDto -> {
                    List<PmsCategoryDto> templist = secondLevel.stream().filter(
                            pmsCategoryDto1 -> {
                                return pmsCategoryDto1.getParentCid() == pmsCategoryDto.getCatId();
                            }
                    ).collect(Collectors.toList());
                    pmsCategoryDto.setSubCategoryList(templist);
                }
        );


        return firstLevel;
    }

    @Override
    public List<PmsCategoryDto> selectAllCategorys1() {

        List<List<PmsCategory>> list = new ArrayList<>();

        list.add(pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_1.getLevel()));
        list.add(pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_2.getLevel()));
        list.add(pmsCategoryMapper.selectByCatLevel(CatLevelEnum.LEVEL_3.getLevel()));

        List<PmsCategoryDto> firstLevel = new ArrayList<>();
        List<PmsCategoryDto> secondLevel = new ArrayList<>();
        List<PmsCategoryDto> thirdLevel = new ArrayList<>();


        //1.装填第三级菜单
        list.get(2).stream().forEach(
                pmsCategory -> {
                    thirdLevel.add(PmsCategoryToDto.PmsCategory2PmsCategoryToDto(pmsCategory,new ArrayList<>()));
                }
        );
        //2.装填第二级菜单

        //2.1 第三级菜单形成parentCid到实体类的映射map
        Map<Integer, List<PmsCategoryDto>> map1 = thirdLevel.stream().collect(Collectors.groupingBy(PmsCategoryDto::getParentCid));

        list.get(1).stream().forEach(
                pmsCategory -> {
                    if(map1.containsKey(pmsCategory.getCatId())){
                        secondLevel.add((PmsCategoryToDto.PmsCategory2PmsCategoryToDto(pmsCategory,map1.get(pmsCategory.getCatId()))));
                    }else{
                        secondLevel.add((PmsCategoryToDto.PmsCategory2PmsCategoryToDto(pmsCategory,new ArrayList<>())));
                    }
                }
        );

        //3.装填第一级菜单

        Map<Integer, List<PmsCategoryDto>> map2 = secondLevel.stream().collect(Collectors.groupingBy(PmsCategoryDto::getParentCid));


        list.get(0).stream().forEach(
                pmsCategory -> {
                    if(map2.containsKey(pmsCategory.getCatId())){
                        firstLevel.add(PmsCategoryToDto.PmsCategory2PmsCategoryToDto(pmsCategory,map2.get(pmsCategory.getCatId())));
                    }else{
                        firstLevel.add(PmsCategoryToDto.PmsCategory2PmsCategoryToDto(pmsCategory,new ArrayList<>()));
                    }
                }
        );

        return firstLevel;
    }
}
