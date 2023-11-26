package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DiscountDto {

    long discountId;
    BigDecimal percentage;
    LocalDateTime startDate;
    LocalDateTime endDate;
    ProductDto products;
    LocalDateTime responseAt;
}
