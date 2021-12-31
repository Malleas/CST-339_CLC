package com.gcu.clc.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="products")
public class ProductList
{
    private List<ProductModel> products = new ArrayList<ProductModel>();

    @XmlElement(name="product")
    public List<ProductModel> getProduct()
    {
        return products;
    }

    public void setProduct(List<ProductModel> products)
    {
        this.products = products;
    }
}
