package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Product;
import lombok.Data;

@Data
public class FileDataDto {

    Long fileDataId;
    String name;
    String type;
    String filePath;
    Product product;
}
