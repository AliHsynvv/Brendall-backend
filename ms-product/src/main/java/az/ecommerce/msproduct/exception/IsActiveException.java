package az.ecommerce.msproduct.exception;

import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import lombok.Getter;

@Getter
public class IsActiveException extends RuntimeException {

    private final String message;
    private final int code;

    public IsActiveException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.message = errorCodeEnum.getMessage();
        this.code = errorCodeEnum.getCode();
    }
}
