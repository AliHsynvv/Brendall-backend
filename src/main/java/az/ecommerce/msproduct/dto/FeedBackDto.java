package az.ecommerce.msproduct.dto;

import jakarta.persistence.*;
import lombok.*;


@Data
public class FeedBackDto {

    long feedId;

    double rank;

    @ManyToOne
    ProductDto product;


}
