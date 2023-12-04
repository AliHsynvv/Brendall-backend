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
    boolean isActivated;
    boolean isDeleted;
    long colourId;
    long  priceId;
    long discountId;
    long feedId;
    long storeId;
    LocalDateTime responseAt;


}
