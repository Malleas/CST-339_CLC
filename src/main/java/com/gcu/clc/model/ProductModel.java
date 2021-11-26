package com.gcu.clc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductModel {

    @NotNull(message="Product name is a required field")
    @Size(min=1, max=32, message="Product name must be between 1 and 32 characters")
    private String productName;

    @NotNull(message="Product description is required")
    @Size(min=1, max=10, message="Product description must be between 1 and 32 characters")
    private String productDescription;

    @NotNull(message="Product price is a required field")
    private float productPrice;

    @NotNull(message="Product quantity is a required field")
    private int productQuantity;

    public ProductModel(String productName, String productDescription, float productPrice, int productQuantity) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public ProductModel() {
    }

    public String getproductName() {
        return productName;

    }
    public void setproductName(String productName) {
        this.productName = productName;

    }

    public String getproductDescription() {
        return productDescription;

    }
    public void setproductDescription(String productDescription) {
        this.productDescription = productDescription;

    }
    public float getproductPrice() {
        return productPrice;

    }
    public void setproductPrice(float productPrice) {
        this.productPrice = productPrice;

    }
    public int getproductQuantity() {
        return productQuantity;
    }

    public void setproductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}