package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceResp {

    long priceId;
    BigDecimal amount;
    LocalDateTime startDate;
    LocalDateTime endDate;
    long productId;
    LocalDateTime responseAt;
}
