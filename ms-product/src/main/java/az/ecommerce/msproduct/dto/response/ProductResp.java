package az.ecommerce.msproduct.dto.response;

import az.ecommerce.msproduct.entity.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductResp {

    long productId;
    String productName;
    String description;
    String productIcons;
    IsActive isActive;
    List<Colour> colourList;
    Price price;
    Discount discount;
    List<FeedBack> feedBackList;
    List<Store> storeList;
    LocalDateTime responseAt;


}
