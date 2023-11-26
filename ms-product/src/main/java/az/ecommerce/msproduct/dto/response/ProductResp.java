package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductResp {

    long productId;
    String productName;
    String description;
    String productIcons;
    IsActiveResp isActive;
    List<ColourResp> colourList;
    PriceResp price;
    DiscountResp discount;
    List<FeedBackResp> feedBackList;
    List<StoreResp> storeList;
    LocalDateTime responseAt;


}
