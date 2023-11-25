package az.ecommerce.msproduct.dto;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class DiscountDto {

    long discountId;
    BigDecimal percentage;
    LocalDateTime startDate;
    LocalDateTime endDate;

    @ManyToOne
    ProductDto products;
}
