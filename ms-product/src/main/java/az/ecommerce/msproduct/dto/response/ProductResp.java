package az.ecommerce.msproduct.dto.response;

import az.ecommerce.msproduct.entity.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProductResp {

    Long productId;
    String productName;
    String description;
    boolean isActivated;
    boolean isDeleted;
    List<Long> colourIds;
    Long priceId;
    Long discountId;
    List<Long> feedIds;
    List<Long> sizeIds;
    List<Long> storeIds;
    Long genderId;
    List<Long> categoryIds;
    List<Long> imageIds;
    List<Long> fileIds;
    LocalDateTime responseAt;


}
