package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Product;
import lombok.Data;

@Data
public class ImageDataDto {

    Long imageDataId;

    String name;
    String type;

    byte[] imageData;

    Product product;

}
