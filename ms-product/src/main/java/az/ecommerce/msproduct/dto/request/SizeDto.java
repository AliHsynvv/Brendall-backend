package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.dto.response.ProductResp;
import lombok.*;

@Data
public class SizeDto {

    Long sizeId;
    String sizeName;
    Long productId;
    ProductResp product;

}
