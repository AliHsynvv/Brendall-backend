package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ColourResp {

    Long colourId;
    String colourName;
    Long productId;
    LocalDateTime responseAt;


}
