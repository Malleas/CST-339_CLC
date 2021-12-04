package com.gcu.clc.business;

import com.gcu.clc.data.DataAccessInterface;
import com.gcu.clc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBusinessService implements ProductBusinessServiceInterface
{
    @Autowired
    private DataAccessInterface<ProductModel> service;


    public List<ProductModel> addProduct();


        return new ProductModel(productName, productDescription, productPrice, productQuantity);
    }
}
