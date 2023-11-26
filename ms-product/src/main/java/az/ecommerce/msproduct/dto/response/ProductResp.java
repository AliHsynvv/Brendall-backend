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
    List<PriceResp> priceList;
    List<DiscountResp> discountList;
    List<FeedBackResp> feedBackList;
    List<StoreResp> storeList;
    LocalDateTime responseAt;


}
