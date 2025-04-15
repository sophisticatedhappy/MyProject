package com.example.gulimallpms.service;

import com.example.gulimallpms.dto.PmsCategoryDto;


import java.util.List;
import java.util.Locale;

public interface PmsCategoryService {

    List<PmsCategoryDto> selectAllCategorys();

    List<PmsCategoryDto> selectAllCategorys1();
}
