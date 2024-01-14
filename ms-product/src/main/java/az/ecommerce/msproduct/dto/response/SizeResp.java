package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SizeResp {

    Long sizeId;
    String sizeName;
    LocalDateTime responseAt = LocalDateTime.now();


}
