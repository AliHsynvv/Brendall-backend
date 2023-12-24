package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Product;
import lombok.*;

@Data
public class ColourDto {

    Long colourId;
    String colourName;
    Long productId;


}
