package com.example.android_project.Models;

public class Product {
    private int prodId, catId, quantity;
    private String ProName;
    private int price;


    public Product() {
    }

    public Product(int catId, int quantity, String proName, int price) {

        this.catId = catId;
        this.quantity = quantity;
        ProName = proName;
        this.price = price;

    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String proName) {
        ProName = proName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
