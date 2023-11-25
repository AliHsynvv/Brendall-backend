package az.ecommerce.msproduct.dto;

import jakarta.persistence.*;
import lombok.*;



@Data


public class SizeDto {

    long sizeId;
    String sizeName;

    @ManyToOne
    ProductDto product;


}
