package az.ecommerce.msproduct.dto.request;

import lombok.*;

@Data
public class ColourDto {

    long colourId;
    String colourName;
    ProductDto products;


}
