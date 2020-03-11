package com.zryx.company.model;

import java.math.BigDecimal;

/**
 * @author 123
 * @create 2019/7/11
 */
public class Product {
    private int productId = 0;
    private String serialNumber;
    private String name;
    private String brand;
    private String model;
    private BigDecimal price;
    private String picture;
    private String description;

    public Product() {
    }
    public Product(int productId, String serialNumber, String name, String brand, String model, BigDecimal price, String picture, String description) {
        this.productId = productId;
        this.serialNumber = serialNumber;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.picture = picture;
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", serialNumber='" + serialNumber + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
