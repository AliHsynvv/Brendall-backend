package az.commerce.msfavproducts.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException {


    private final int code;


    public NotFoundException (String message, int code){
        super(message);
        this.code=code;

    }
}
