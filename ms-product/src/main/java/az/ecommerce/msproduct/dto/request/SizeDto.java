package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Product;
import lombok.*;

@Data
public class SizeDto {

    long sizeId;
    String sizeName;
    long productId;


}
