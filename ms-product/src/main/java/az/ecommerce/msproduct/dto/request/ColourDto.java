package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.dto.response.ProductResp;
import lombok.*;

@Data
public class ColourDto {

    Long colourId;
    String colourName;
    ProductResp product;


}
