package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FeedBackResp {

    Long feedId;
    double feedRank;
    LocalDateTime responseAt = LocalDateTime.now();


}
