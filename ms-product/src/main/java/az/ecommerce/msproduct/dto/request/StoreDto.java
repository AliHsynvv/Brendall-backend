package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.FileData;
import az.ecommerce.msproduct.entity.Product;
import lombok.*;

import java.util.List;

@Data
public class StoreDto {

    Long storeId;
    String storeName;
    FileData storeIcon;
    List<Long> productIds;
    List<Long> locationIds;



}
