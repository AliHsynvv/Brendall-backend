package az.ecommerce.msproduct.dto.response;

import az.ecommerce.msproduct.entity.Category;
import az.ecommerce.msproduct.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryResp {

    long id;
    String name;
    List<Category> subCategory;
    List<Long> productIds;
    LocalDateTime responseAt;

}
