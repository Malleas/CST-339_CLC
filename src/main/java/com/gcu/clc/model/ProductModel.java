package com.gcu.clc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductModel {
    @NotNull(message = "Item name is a required field")
    @Size(min = 1, max = 32, message = "Item name must be between 1 and 32 characters")
    private String productName;

    @NotNull(message = "Item description is required")
    @Size(min = 1, max = 10, message = "Item description must be between 1 and 32 characters")
    private String productDescription;

    @NotNull(message = "Item price is a required field")
    @Size(min = 1, max = 32, message = "Item price must be between 1 and 32 characters")
    private float productPrice;

    @NotNull(message = "Item quantity is a required field")
    @Size(min = 1, max = 32, message = "Item quantity must be between 1 and 32 characters")
    private int productQuantity;

    public ProductModel() {
    }

    public ProductModel(String productName, String productDescription, float productPrice, int productQuantity) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}