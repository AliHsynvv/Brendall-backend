package az.ecommerce.msproduct.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

    @ManyToOne
    Product product;


}
