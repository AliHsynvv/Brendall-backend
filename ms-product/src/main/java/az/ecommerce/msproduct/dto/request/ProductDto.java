package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.*;
import lombok.*;

import java.util.List;

@Data
public class ProductDto {

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
    Gender gender;
    Category category;


}
