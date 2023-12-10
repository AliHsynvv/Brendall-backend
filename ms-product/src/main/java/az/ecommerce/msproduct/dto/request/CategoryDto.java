package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Category;
import az.ecommerce.msproduct.entity.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDto {

    long id;
    String name;
    List<Category> subCategory;
    List<Long> productIds;

}
