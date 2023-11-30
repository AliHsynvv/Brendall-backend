package az.ecommerce.msproduct.dto.request;

import lombok.*;

import java.util.List;

@Data
public class StoreDto {

    long storeId;
    String storeName;
    String storeIcon;
    String storeLocation;
    List<ProductDto> productList;



}
