package com.example.gulimalladmin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    public Integer menuId;

    public Integer parentId;

    public String name;

    public String url;

    public String perms;

    public Integer type;

    public String icon;

    public Integer orderNum;

}
