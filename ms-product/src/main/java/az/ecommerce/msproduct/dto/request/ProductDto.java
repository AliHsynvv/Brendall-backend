package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.*;
import lombok.*;

import java.util.List;

@Data
public class ProductDto {

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
    List<Long> categoryIds;
    List<Long> imageIds;
    List<Long> fileIds;


}
