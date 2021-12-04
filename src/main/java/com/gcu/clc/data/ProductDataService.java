package com.gcu.clc.data;

import com.gcu.clc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDataService implements DataAccessInterface<ProductModel> {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public ProductDataService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<ProductModel> findAll()
    {
        String sql = "SELECT * FROM PRODUCTS";
        List<ProductModel> products = new ArrayList<ProductModel>();
        try {
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) {
                products.add(new ProductModel(srs.getString("PRODUCT_NAME"),
                        srs.getString("PRODUCT_DESCRIPTION"),
                        srs.getFloat("PRODUCT_PRICE"),
                        srs.getInt("PRODUCT_QTY")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return products;
    }

    public ProductModel findById(int id) {return null;}

    public boolean create(ProductModel products)
    {
        String sql = "INSERT INTO PRODUCTS(PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_PRICE, PRODUCT_QTY) VALUES(?, ?, ?, ?)";
        try
        {
            int rows = jdbcTemplateObject.update(sql,
                    )                           products.getProductName(),
                                                products.getProductDescription(),
                                                products.getProductPrice(),
                                                products.getProductQuantity());

            return rows == 1 ? true : false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
