package az.ecommerce.msproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceId;
    private BigDecimal amount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToOne(mappedBy = "price")
    @JsonBackReference
    private Product product;
}