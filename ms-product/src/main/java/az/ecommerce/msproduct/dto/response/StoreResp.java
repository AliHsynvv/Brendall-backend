package az.ecommerce.msproduct.dto.response;

import az.ecommerce.msproduct.entity.FileData;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class StoreResp {

    Long storeId;
    String storeName;
    FileData storeIcon;
    List<Long> productIds;
    List<Long> locationIds;
    LocalDateTime responseAt;

}
