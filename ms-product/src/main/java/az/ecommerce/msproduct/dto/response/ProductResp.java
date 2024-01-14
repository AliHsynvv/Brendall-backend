package az.ecommerce.msproduct.dto.response;

import az.ecommerce.msproduct.dto.request.*;
import az.ecommerce.msproduct.entity.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductResp {

    Long productId;
    String productName;
    String description;
    boolean isActivated;
    boolean isDeleted;
    List<ColourResp> colourList;
    PriceResp price;
    DiscountResp discount;
    List<SizeResp> sizeList;
    List<StoreResp> storeList;
    GenderResp gender;
    List<CategoryResp> categoryList;
    List<ImageDataResp> imageDataList;
    List<FileDataResp> fileDataList;
    LocalDateTime responseAt = LocalDateTime.now();

}
