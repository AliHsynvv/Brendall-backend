package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LocationResp {


    long locationId;
    double latitude;
    double longitude;
    long storeId;
    LocalDateTime responseAt;
}
