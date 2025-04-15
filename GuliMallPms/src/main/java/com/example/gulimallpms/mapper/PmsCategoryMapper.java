package com.example.gulimallpms.mapper;

import com.example.gulimallpms.entity.PmsCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsCategoryMapper {

    List<PmsCategory> selectByCatLevel(@Param("catLevel") Integer catLevel);

}
