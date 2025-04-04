package com.example.mybatisdemo.demos.web.Enum;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 性别枚举
 *
 * @author william@StarImmortal
 */
@Getter
@AllArgsConstructor
public enum DeleteEnum {


    /**
     * 男性
     */
    DELETE_ENUM(1, "已删除"),

    /**
     * 女性
     */
    UNDELETE_ENUM(0, "未删除");

    private final Integer value;

    @JsonFormat
    private final String description;

    public static DeleteEnum convert(Integer value) {
        return Stream.of(values())
                .filter(bean -> bean.value.equals(value))
                .findAny()
                .orElse(UNDELETE_ENUM);
    }

    public static DeleteEnum convert(String description) {
        return Stream.of(values())
                .filter(bean -> bean.description.equals(description))
                .findAny()
                .orElse(UNDELETE_ENUM);
    }
}
