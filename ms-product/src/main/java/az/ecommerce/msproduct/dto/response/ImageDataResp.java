package az.ecommerce.msproduct.dto.response;

import az.ecommerce.msproduct.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ImageDataResp {
    Long imageDataId;

    String name;
    String type;

    byte[] imageData;

    LocalDateTime responseAt = LocalDateTime.now();

}
