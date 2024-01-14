package az.ecommerce.msproduct.dto.response;

import az.ecommerce.msproduct.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileDataResp {
    Long fileDataId;
    String name;
    String type;
    String filePath;
    LocalDateTime responseAt = LocalDateTime.now();
}
