package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FeedBackResp {

    long feedId;
    double feedRank;
    String feedIcon;
    String feedComment;
    ProductResp product;
    LocalDateTime responseAt;


}
