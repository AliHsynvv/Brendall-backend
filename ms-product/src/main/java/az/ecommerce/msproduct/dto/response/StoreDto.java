package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class StoreDto {

    long storeId;
    String storeName;
    String storeIcon;
    String storeLocation;
    List<ProductDto> productList;
    LocalDateTime responseAt;



}
