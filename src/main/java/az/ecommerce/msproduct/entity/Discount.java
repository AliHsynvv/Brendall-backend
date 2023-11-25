package az.ecommerce.msproduct.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long discountId;
    BigDecimal percentage;
    LocalDateTime startDate;
    LocalDateTime endDate;

    @ManyToOne
    Product products;
}
