package com.ra.entity;

public class Product {
    private String id;
    private String name;
    private int categoryId;
    private String image;
    private String listImg;
    private float price;
    private float salePrice;
    private String description;
    private String keyword;
    private String content;
    private boolean status;

    public Product() {
    }

    public Product(String id, String name, int categoryId, String image, String listImg, float price, float salePrice, String description, String keyword, String content, boolean status) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.image = image;
        this.listImg = listImg;
        this.price = price;
        this.salePrice = salePrice;
        this.description = description;
        this.keyword = keyword;
        this.content = content;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}