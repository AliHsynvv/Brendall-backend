package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Product;
import lombok.*;

@Data
public class SizeDto {

    Long sizeId;
    String sizeName;
    Long productId;


}
