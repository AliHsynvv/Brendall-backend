package az.ecommerce.msproduct.dto.request;

import lombok.*;

@Data
public class SizeDto {

    Long sizeId;
    String sizeName;
    Long productId;
    ProductDto product;

}
