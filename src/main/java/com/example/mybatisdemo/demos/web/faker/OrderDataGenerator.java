package com.example.mybatisdemo.demos.web.faker;

import com.example.mybatisdemo.demos.web.entity.Order;
import com.github.javafaker.Faker;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Locale;

public class OrderDataGenerator {

    private static final Faker faker = new Faker(Locale.CHINA); // 根据需要选择区域

    public static Order generateRandomOrder() {
        Order order = new Order();

        order.setId(faker.number().numberBetween(1L, 1_000_000L)); // 自增主键通常由数据库管理，这里仅作示例
        order.setOrderNo(generateOrderNo());
        order.setCustomerNo(faker.code().ean8()); // 或其他合适的客户编号格式
        order.setWarehouseCode("WH" + faker.number().numberBetween(1000, 9999));
        order.setOrderStatus(faker.number().numberBetween(0, 9)); // 假设订单状态有10种
//        order.setCountry(faker.address().country());
        order.setCountry("CHINA!");
        order.setState(faker.address().state());
        order.setCity(faker.address().city());
        order.setStreet(faker.address().streetAddress());
        order.setZipCode(faker.address().zipCode());
        order.setContactEmail(faker.internet().emailAddress());
        order.setContactName(faker.name().fullName());
        order.setContactMobile(faker.phoneNumber().cellPhone());

        // 设置创建时间和更新时间，假设创建时间在当前时间之前，更新时间为当前时间或稍早
        LocalDateTime now = LocalDateTime.now();
        order.setCreateTime(now.minusDays(faker.number().numberBetween(0, 365)));
        order.setUpdateTime(now.minusHours(faker.number().numberBetween(0, 24)));

        order.setDeleted(faker.number().numberBetween(0, 1)); // 0 或 1

        return order;
    }

    private static String generateOrderNo() {
        // 示例订单编号格式：ORD-YYYYMMDD-XXXX
        String datePart = LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd"));
        String randomPart = String.format("%04d", faker.number().numberBetween(1000, 9999));
        return "ORD" + datePart + "-" + randomPart;
    }

    // 示例主方法
    public static void main(String[] args) {
        Order randomOrder = generateRandomOrder();
        System.out.println(randomOrder);
    }
}
