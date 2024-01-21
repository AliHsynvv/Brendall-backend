package az.ecommerce.msproduct.dto.response;

import az.ecommerce.msproduct.entity.Category;
import az.ecommerce.msproduct.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryResp {

    Long categoryId;
    String name;
    List<Category> subCategory;
    CategoryResp parentCategory;
    Long parentId;
    LocalDateTime responseAt = LocalDateTime.now();

}
