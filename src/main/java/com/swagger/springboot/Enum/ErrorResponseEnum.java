package com.swagger.springboot.Enum;

import org.springframework.http.HttpStatus;

public enum ErrorResponseEnum {
    GET_PRODUCT_BY_ID_400 (
        HttpStatus.BAD_REQUEST,
        "PRODUCT_ERR_1",
        "Invalid product id",
        "getProductById"),
    GET_PRODUCT_BY_ID_404 (
        HttpStatus.NOT_FOUND,
        "PRODUCT_ERR_2",
        "Product not found",
        "getProductById"
    ),
    GET_PRODUCT_BY_ID_500 (
        HttpStatus.INTERNAL_SERVER_ERROR,
        "PRODUCT_ERR_3",
        "Internal server error",
        "getProductById"
    ),
    ADD_PRODUCT_400 (
        HttpStatus.BAD_REQUEST,
        "PRODUCT_ERR_4",
        "Invalid input param",
        "addProduct"
    ),
    ADD_PRODUCT_500 (
        HttpStatus.INTERNAL_SERVER_ERROR,
        "PRODUCT_ERR_5",
        "Internal server error",
        "addProduct"
    );

    private HttpStatus httpStatus;
    private String code;
    private String message;
    private String operationId;

    ErrorResponseEnum(HttpStatus httpStatus, String code, String message, String operationId) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.operationId = operationId;
    }

    public HttpStatus geHttpStatus() {
        return this.httpStatus;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getOperationId() {
        return this.operationId;
    }
}
