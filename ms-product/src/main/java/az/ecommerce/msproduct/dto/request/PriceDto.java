package az.ecommerce.msproduct.dto.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceDto {

    long priceId;
    BigDecimal amount;
    LocalDateTime startDate;
    LocalDateTime endDate;
    ProductDto products;
}
