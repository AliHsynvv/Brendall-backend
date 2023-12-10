package az.ecommerce.msproduct.dto.response;

import az.ecommerce.msproduct.entity.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProductResp {

    long productId;
    String productName;
    String description;
    boolean isActivated;
    boolean isDeleted;
    List<Long> colourIds;
    long priceId;
    long discountId;
    List<Long> feedIds;
    List<Long> sizeIds;
    List<Long> storeIds;
    long genderId;
    long categoryId;
    List<Long> imageIds;
    List<Long> fileIds;
    LocalDateTime responseAt;


}
