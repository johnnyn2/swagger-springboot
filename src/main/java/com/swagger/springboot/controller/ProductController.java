package com.swagger.springboot.controller;

import org.apache.commons.lang3.StringUtils;
import org.openapitools.api.ProductsApi;
import org.openapitools.model.ProductRequest;
import org.openapitools.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.springboot.Enum.ErrorResponseEnum;
import com.swagger.springboot.exception.ProductRequestException;
import com.swagger.springboot.model.Product;
import com.swagger.springboot.service.ProductService;


@RestController
public class ProductController implements ProductsApi {
    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<ProductResponse> getProductById(String productId) {
        if (StringUtils.isBlank(productId)) {
            throw new ProductRequestException(ErrorResponseEnum.GET_PRODUCT_BY_ID_400, "");
        }
        if (!productService.isProductExist(productId)) {
            throw new ProductRequestException(ErrorResponseEnum.GET_PRODUCT_BY_ID_404, ""); 
        }
        try {
            Product p = productService.getProductById(productId);
            ProductResponse response = new ProductResponse();
            response.setName(p.getName());
            response.setDescription(p.getDescription());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new ProductRequestException(ErrorResponseEnum.GET_PRODUCT_BY_ID_500, "Reason: " + e.getMessage());
        }
    }
    @Override
    public ResponseEntity<ProductResponse> addProduct(ProductRequest productRequest) {
        if (StringUtils.isBlank(productRequest.getName())) {
            throw new ProductRequestException(ErrorResponseEnum.ADD_PRODUCT_400, ".Reason: empty product name");
        }
        try {
            Product product = productService.addProduct(productRequest.getName(), productRequest.getDescription());
            ProductResponse response = new ProductResponse();
            response.setName(product.getName());
            response.setDescription(product.getDescription());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new ProductRequestException(ErrorResponseEnum.ADD_PRODUCT_500, ".Reason: " + e.getMessage());
        }
    }
}
