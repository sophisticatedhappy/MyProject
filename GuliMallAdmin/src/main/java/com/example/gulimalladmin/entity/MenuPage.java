package com.example.gulimalladmin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuPage {

    public Integer pageSize;

    public Integer offset;
}
