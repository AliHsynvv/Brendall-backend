package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Product;
import lombok.*;

import java.util.List;

@Data
public class ColourDto {

    long colourId;
    String colourName;
    List<Long> productIds;



}
