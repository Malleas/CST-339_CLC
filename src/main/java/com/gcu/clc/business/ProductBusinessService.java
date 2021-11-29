package com.gcu.clc.business;

import com.gcu.clc.model.ProductModel;
import org.springframework.stereotype.Service;

@Service
public class ProductBusinessService {

    public ProductModel addProduct(String productName, String productDescription, Float productPrice, Integer productQuantity){
        System.out.println("Product Name: " + productName + "\n" +
                "Product Description: " + productDescription + "\n" +
                "Price: " + productPrice + "\n" +
                "Quantity: " + productQuantity);
        return new ProductModel(productName, productDescription, productPrice, productQuantity);
    }
}
