package az.ecommerce.msproduct.controller.response;

import az.ecommerce.msproduct.entity.Product;
import az.ecommerce.msproduct.exception.ProductException;
import az.ecommerce.msproduct.exception.StoreException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerProduct {

    @ExceptionHandler(ProductException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCustomNotFoundException(ProductException e) {
        return ErrorResponse.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }

}
