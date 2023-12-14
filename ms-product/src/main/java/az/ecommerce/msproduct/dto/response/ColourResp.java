package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ColourResp {

    long colourId;
    String colourName;
    List<Long> productIds;
    LocalDateTime responseAt;


}
