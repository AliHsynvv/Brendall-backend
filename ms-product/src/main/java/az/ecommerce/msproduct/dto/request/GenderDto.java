package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.Product;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GenderDto {

    Long id;
    String name;
    List<Long> productIds;

}


