package az.commerce.msfavproducts.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {

    UNKNOWN_ERROR(1000, "Unknown error!"),
    FAVPRODUCT_NOT_FOUND(1001, "Cannot find favProduct with given id!");


    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
