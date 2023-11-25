package az.ecommerce.msproduct.dto;

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
