package az.ecommerce.msproduct.dto.request;

import lombok.*;

import java.util.List;

@Data
public class ProductDto {

    long productId;
    String productName;
    String description;
    String productIcons;
    IsActiveDto isActive;
    List<ColourDto> colourList;
    PriceDto price;
    DiscountDto discount;
    List<FeedBackDto> feedBackList;
    List<StoreDto> storeList;


}
