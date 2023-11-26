package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ColourDto {

    long colourId;
    String colourName;
    ProductDto products;
    LocalDateTime responseAt;


}
