package az.ecommerce.msproduct.dto;

import jakarta.persistence.*;
import lombok.*;



@Data

public class IsActiveDto {

    long activeId;
    boolean isActive;

    @OneToOne(mappedBy = "isActive")
    ProductDto product;

}
