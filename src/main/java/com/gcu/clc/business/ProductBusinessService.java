package com.gcu.clc.business;

import com.gcu.clc.data.ProductDataService;
import com.gcu.clc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBusinessService {

    @Autowired
    private ProductDataService productDataService;

    public boolean addProduct(ProductModel productModel){
       return productDataService.create(productModel);
    }
    public List<ProductModel> getAll() {
        return productDataService.getAll();
    }
    public boolean updateProduct(ProductModel productModel){
        return productDataService.update(productModel);
    }

    public boolean deleteProduct(ProductModel productModel)
    {
        return productDataService.delete(productModel);
    }
}
