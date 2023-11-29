package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDto {
    Long id;
    String name;

    List<Product> products = new ArrayList<>();

}
