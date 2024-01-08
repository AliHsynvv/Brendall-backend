package az.commerce.msfavproducts.exception;

import az.commerce.msfavproducts.enums.ErrorCodeEnum;
import lombok.Getter;

@Getter
public class FavProductException extends RuntimeException {

    private final String message;
    private final int code;

    public FavProductException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.message = errorCodeEnum.getMessage();
        this.code = errorCodeEnum.getCode();
    }


}
