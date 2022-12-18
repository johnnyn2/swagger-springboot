package com.swagger.springboot.exception;

import org.springframework.http.HttpStatus;

import com.swagger.springboot.Enum.ErrorResponseEnum;

public class ProductRequestException extends RuntimeException{
    private HttpStatus httpStatus;
    private String code;
    private String operationId;
    private String message;

    public ProductRequestException(ErrorResponseEnum errorResponseEnum, String message) {
        super(errorResponseEnum.getMessage());
        this.httpStatus = errorResponseEnum.geHttpStatus();
        this.code = errorResponseEnum.getCode();
        this.operationId = errorResponseEnum.getOperationId();
        this.message = errorResponseEnum.getMessage() + message;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return this.code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationId() {
        return this.operationId;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
