package com.gcu.clc.model;

import org.hibernate.validator.constraints.Range;

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
    @Range(min=1, max=1000, message="Product price must be between 1 and 10 characters")
    private Float productPrice;

    @NotNull(message="Product quantity is a required field")
    @Range(min=1, max=1000, message="Product quantity must be between 1 and 10 characters")
    private Integer productQuantity;

    public ProductModel(String productName, String productDescription, Float productPrice, Integer productQuantity) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public ProductModel() {
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

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}