package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LocationResp {


    Long locationId;
    double latitude;
    double longitude;
    LocalDateTime responseAt = LocalDateTime.now();
}
