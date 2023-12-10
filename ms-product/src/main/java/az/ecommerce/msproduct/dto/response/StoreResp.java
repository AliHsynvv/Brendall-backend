package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class StoreResp {

    long storeId;
    String storeName;
    String storeIcon;
    String storeLocation;
    List<Long> productIds;
    LocalDateTime responseAt;

}
