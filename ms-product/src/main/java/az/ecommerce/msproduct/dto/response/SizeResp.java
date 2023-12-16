package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SizeResp {

    long sizeId;
    String sizeName;
    List<Long> productIds;
    LocalDateTime responseAt;


}
