package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class IsActiveDto {

    long activeId;
    boolean isActive;
    ProductDto product;
    LocalDateTime responseAt;

}
