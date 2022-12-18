package com.swagger.springboot.service;

import org.springframework.stereotype.Service;

import com.swagger.springboot.model.Product;

@Service
public class ProductService {
    public Boolean isProductExist(String id) {
        return !id.equalsIgnoreCase("0");
    }
    public Product getProductById(String id) throws Exception {
        Product product = new Product("1", "product01", "my product", "s3://mycompanyabc123/product/product01.png");
        if (id.equalsIgnoreCase("server-error")) { throw new Exception("db transaction error"); }
        return product;
    }

    public Product addProduct(String productName, String productDescription) throws Exception {
        if (productName.equalsIgnoreCase("server-error")) { throw new Exception("db transaction error"); }
        Product product = new Product("1", productName, productDescription, "s3://mycompanyabc123/product/product01.png");
        return product;
    }
}
