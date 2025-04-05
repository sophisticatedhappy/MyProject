package com.example.mybatisdemo.demos.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 销售订单表实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    /**
     * 自增主键
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 客户编号
     */
    private String customerNo;

    /**
     * 发货地仓库编码
     */
    private String warehouseCode;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 收货人国家
     */
    private String country;

    /**
     * 收货人州
     */
    private String state;

    /**
     * 收货人城市
     */
    private String city;

    /**
     * 收货人街道
     */
    private String street;

    /**
     * 收货人邮编
     */
    private String zipCode;

    /**
     * 收货人邮箱
     */
    private String contactEmail;

    /**
     * 收货人姓名
     */
    private String contactName;

    /**
     * 收货人手机号
     */
    private String contactMobile;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否已被删除 (0: 未删除, 1: 已删除)
     */
    private Integer deleted;

}
