package az.ecommerce.msproduct.dto.response;

import az.ecommerce.msproduct.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GenderResp {
    private Long id;
    private String name;
    private List<Product> products;
    LocalDateTime responseAt;
}


