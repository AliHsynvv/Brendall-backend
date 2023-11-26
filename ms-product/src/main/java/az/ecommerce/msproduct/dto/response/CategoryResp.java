package az.ecommerce.msproduct.dto.response;

import az.ecommerce.msproduct.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryResp {
    Long id;
    String name;
    List<Product> products = new ArrayList<>();
    LocalDateTime responseAt;

}
