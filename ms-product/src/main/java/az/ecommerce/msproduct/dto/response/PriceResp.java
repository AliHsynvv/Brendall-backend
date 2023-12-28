package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceResp {

    Long priceId;
    BigDecimal amount;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Long productId;
    LocalDateTime responseAt;
}
