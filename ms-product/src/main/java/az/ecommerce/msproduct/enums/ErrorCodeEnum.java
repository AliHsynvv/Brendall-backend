package az.ecommerce.msproduct.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {

    UNKNOWN_ERROR(1000, "Unknown error!"),
    PRODUCT_NOT_FOUND(1001, "Cannot find product with given id!"),
    NOT_ENOUGH_PRODUCT(1002, "Training not found!"),
    NOT_ENOUGH_STORE(1002, "Training not found!"),
    STORE_NOT_FOUND(1002, "Cannot find store with given id!"),
    INVALID_FILE(1003,"File is invalid!");


    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
