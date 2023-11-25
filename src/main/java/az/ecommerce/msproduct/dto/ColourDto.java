package az.ecommerce.msproduct.dto;

import jakarta.persistence.*;
import lombok.*;


@Data
public class ColourDto {

    long colourId;
    String colourName;

    @ManyToOne
    ProductDto products;


}
