package com.gcu.clc.business;

import com.gcu.clc.data.ProductDataService;
import com.gcu.clc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBusinessService {

    @Autowired
    private ProductDataService productDataService;

    public boolean addProduct(ProductModel productModel){
       return productDataService.create(productModel);
    }

    public boolean deleteProduct(int id)
    {
        return productDataService.delete(id);
    }

    public ProductModel getProduct(int id)
    {
        return productDataService.getById(id);
    }
}
