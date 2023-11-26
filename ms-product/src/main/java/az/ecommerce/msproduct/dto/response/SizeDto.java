package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SizeDto {

    long sizeId;
    String sizeName;
    ProductDto product;
    LocalDateTime responseAt;


}
