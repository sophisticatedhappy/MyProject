package com.example.gulimallpms.transfer;

import com.example.gulimallpms.dto.PmsCategoryDto;
import com.example.gulimallpms.entity.PmsCategory;

import java.util.List;

public class PmsCategoryToDto {

    public static PmsCategoryDto PmsCategory2PmsCategoryToDto(PmsCategory pmscategory, List<PmsCategoryDto> list){
        PmsCategoryDto pmsCategoryDto = new PmsCategoryDto();
        pmsCategoryDto.setCatId(pmscategory.getCatId());
        pmsCategoryDto.setName(pmscategory.getName());
        pmsCategoryDto.setParentCid(pmscategory.getParentCid());
        pmsCategoryDto.setCatLevel(pmscategory.getCatLevel());
        pmsCategoryDto.setShowStatus(pmscategory.getShowStatus());
        pmsCategoryDto.setSort(pmscategory.getSort());
        pmsCategoryDto.setIcon(pmscategory.getIcon());
        pmsCategoryDto.setProductUnit(pmscategory.getProductUnit());
        pmsCategoryDto.setProductCount(pmscategory.getProductCount());
        pmsCategoryDto.setSubCategoryList(list);
        return pmsCategoryDto ;
    }
}
