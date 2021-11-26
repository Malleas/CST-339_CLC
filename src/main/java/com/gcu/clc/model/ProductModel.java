package com.gcu.clc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductModel {
    @NotNull(message="Product ID is a required field")
    @Size(min=1, max=32, message="Product ID must be between 1 and 32 characters")
    private String productID;

    @NotNull(message="Product name is a required field")
    @Size(min=1, max=32, message="Product name must be between 1 and 32 characters")
    private String productName;

    @NotNull(message="Product type is a required field")
    @Size(min=1, max=32, message="Product type must be between 1 and 32 characters")
    private String productType;

    @NotNull(message="Product description is required")
    @Size(min=1, max=10, message="Product description must be between 1 and 32 characters")
    private String productDescription;

    @NotNull(message="Product price is a required field")
    @Size(min=1, max=32, message="Product price must be between 1 and 32 characters")
    private String productPrice;

    @NotNull(message="Product quantity is a required field")
    @Size(min=1, max=32, message="Product quantity must be between 1 and 32 characters")
    private String productQuantity;

    public ProductModel(String productID, String productName, String productType, String productDescription, String productPrice, String productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public ProductModel() {
    }

    public String getproductID() {
        return productID;

    }
    public void setproductID(String productID) {
        this.productID = productID;

    }
    public String getproductName() {
        return productName;

    }
    public void setproductName(String productName) {
        this.productName = productName;

    }
    public String getproductType() {
        return productType;

    }
    public void setproductType(String productType) {
        this.productType = productType;

    }
    public String getproductDescription() {
        return productDescription;

    }
    public void setproductDescription(String productDescription) {
        this.productDescription = productDescription;

    }
    public String getproductPrice() {
        return productPrice;

    }
    public void setproductPrice(String productPrice) {
        this.productPrice = productPrice;

    }
    public String getproductQuantity() {
        return productQuantity;
    }

    public void setproductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }
}