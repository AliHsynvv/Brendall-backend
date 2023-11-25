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
public class IsActive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long activeId;
    boolean isActive;

    @OneToOne(mappedBy = "isActive")
    Product product;

}
