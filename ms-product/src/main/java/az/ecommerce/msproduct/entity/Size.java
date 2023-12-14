package az.ecommerce.msproduct.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long sizeId;
    String sizeName;

    @ManyToMany
    List<Product> productList;


}
