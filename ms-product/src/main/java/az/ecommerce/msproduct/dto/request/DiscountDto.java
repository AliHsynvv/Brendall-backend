package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Product;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DiscountDto {

    Long discountId;
    BigDecimal percentage;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Long productId;
}
