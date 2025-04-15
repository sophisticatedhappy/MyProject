package com.example.gulimallpms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmsCategory {

    public Integer catId;

    public String name;

    public Integer parentCid;

    public Integer catLevel;

    public Integer showStatus;

    public Integer sort;

    public String icon;

    public String productUnit;

    public Integer productCount;

}
