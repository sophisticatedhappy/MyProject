package com.example.mybatisdemo.demos.web.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.example.mybatisdemo.demos.web.converter.DeleteConverter;
import com.example.mybatisdemo.demos.web.converter.LocalDateTimeToStringConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelIgnoreUnannotated
public class Subject {

    @ExcelProperty(value = "主键id",index = 0)
    private Long id; // 推荐使用 Long 类型

    @ExcelProperty(value = "标题",index = 1)
    private String title;

    @ExcelProperty(value = "父id",index = 2)
    private Long parentId; // 如果数据库字段是 BIGINT

    @ExcelProperty(value = "排序字段",index = 3)
    private Integer sort; // 使用 Integer 更合适

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ExcelProperty(value = "创建时间",index = 4,converter = LocalDateTimeToStringConverter.class)
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ExcelProperty(value = "更新时间",index = 5,converter = LocalDateTimeToStringConverter.class)
    private LocalDateTime updateTime;

    @ExcelProperty(value = "是否删除",index = 6,converter = DeleteConverter.class)
    private Integer isDeleted; // 使用 Integer 更合适
}
