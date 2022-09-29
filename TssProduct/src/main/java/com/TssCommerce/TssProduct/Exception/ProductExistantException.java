package com.TssCommerce.TssProduct.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class ProductExistantException extends RuntimeException {
    public ProductExistantException(String message) {
        super(message);
    }
}
