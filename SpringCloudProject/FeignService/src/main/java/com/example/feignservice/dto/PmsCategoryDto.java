package com.example.feignservice.dto;

import com.example.feignservice.entity.PmsCategory;
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
