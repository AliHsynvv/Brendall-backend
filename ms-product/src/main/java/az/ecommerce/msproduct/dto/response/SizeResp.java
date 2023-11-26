package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SizeResp {

    long sizeId;
    String sizeName;
    ProductResp product;
    LocalDateTime responseAt;


}
