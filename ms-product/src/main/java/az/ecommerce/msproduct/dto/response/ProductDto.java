package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductDto {

    long productId;
    String productName;
    String description;
    String productIcons;
    IsActiveDto isActive;
    List<ColourDto> colourList;
    List<PriceDto> priceList;
    List<DiscountDto> discountList;
    List<FeedBackDto> feedBackList;
    List<StoreDto> storeList;
    LocalDateTime responseAt;


}
