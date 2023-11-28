package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DiscountResp {

    long discountId;
    BigDecimal percentage;
    LocalDateTime startDate;
    LocalDateTime endDate;
    ProductResp products;
    LocalDateTime responseAt;
}
