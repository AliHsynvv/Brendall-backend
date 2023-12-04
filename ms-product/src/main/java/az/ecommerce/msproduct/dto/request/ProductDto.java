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
    long colourId;
    long priceId;
    long discountId;
    long feedId;
    long storeId;
    long genderId;
    long categoryId;


}
