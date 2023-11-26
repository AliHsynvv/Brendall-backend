package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FeedBackResp {

    long feedId;
    double rank;
    ProductResp product;
    LocalDateTime responseAt;


}
