package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.FileData;
import az.ecommerce.msproduct.entity.Product;
import lombok.*;

import java.util.List;

@Data
public class StoreDto {

    long storeId;
    String storeName;
    FileData storeIcon;
    List<Long> productIds;



}
