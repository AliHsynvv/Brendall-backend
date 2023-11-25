package az.ecommerce.msproduct.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data

public class StoreDto {


    long storeId;

    String storeName;
    String storeIcon;
    String storeLocation;

    @ManyToMany(mappedBy = "storeList")
    List<ProductDto> productList;



}
