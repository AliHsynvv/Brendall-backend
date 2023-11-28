package az.ecommerce.msproduct.dto.request;

import lombok.*;

@Data
public class FeedBackDto {

    long feedId;
    double feedRank;
    String feedIcon;
    String feedComment;
    ProductDto product;


}
