package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Store;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class LocationDto {

    Long locationId;
    double latitude;
    double longitude;
    Long storeId;
}
