package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FeedBackDto {

    long feedId;
    double rank;
    ProductDto product;
    LocalDateTime responseAt;


}
