package az.ecommerce.msproduct.dto;

import lombok.*;

@Data

public class IsActiveDto {

    long activeId;
    boolean isActive;
    ProductDto product;

}
