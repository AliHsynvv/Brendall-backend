package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Product;
import lombok.*;

import java.util.List;

@Data
public class SizeDto {

    long sizeId;
    String sizeName;
    List<Long> productIds;


}
