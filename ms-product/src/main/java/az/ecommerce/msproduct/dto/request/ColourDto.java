package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Product;
import lombok.*;

@Data
public class ColourDto {

    long colourId;
    String colourName;
    Product products;


}
