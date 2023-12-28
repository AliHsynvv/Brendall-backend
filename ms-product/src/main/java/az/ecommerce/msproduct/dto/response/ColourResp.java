package az.ecommerce.msproduct.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ColourResp {

    Long colourId;
    String colourName;
<<<<<<< HEAD
    List<Long> productIds;
=======
    Long productId;
>>>>>>> origin/Qiyas
    LocalDateTime responseAt;


}
