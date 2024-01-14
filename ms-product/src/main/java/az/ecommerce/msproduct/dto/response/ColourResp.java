package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ColourResp {

    Long colourId;
    String colourName;
    LocalDateTime responseAt = LocalDateTime.now();


}
