package com.example.gulimallpms.dto;

import com.example.gulimallpms.entity.PmsCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmsCategoryDto extends PmsCategory {

    List<PmsCategoryDto> subCategoryList;

}
