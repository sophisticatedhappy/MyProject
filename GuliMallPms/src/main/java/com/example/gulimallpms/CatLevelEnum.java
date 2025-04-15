package com.example.gulimallpms;

public enum CatLevelEnum {
    // 表示一级分类
    LEVEL_1(1),
    // 表示二级分类
    LEVEL_2(2),
    // 表示三级分类
    LEVEL_3(3);

    private final int level;

    // 构造函数，用于初始化枚举实例的级别值
    CatLevelEnum(int level) {
        this.level = level;
    }

    // 获取枚举实例对应的级别值
    public int getLevel() {
        return level;
    }
}
