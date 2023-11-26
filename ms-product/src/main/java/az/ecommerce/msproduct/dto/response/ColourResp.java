package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ColourResp {

    long colourId;
    String colourName;
    ProductResp products;
    LocalDateTime responseAt;


}
