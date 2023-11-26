package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class IsActiveResp {

    long activeId;
    boolean isActive;
    ProductResp product;
    LocalDateTime responseAt;

}
