package az.ecommerce.msproduct.dto.request;

import lombok.*;

@Data

public class IsActiveDto {

    long activeId;
    boolean isActive;
    ProductDto product;

}
