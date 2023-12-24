package az.ecommerce.msproduct.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;

    @Min(value = 1)
    @Max(value = 5)
    private double feedRank;

    @ManyToOne
    private Product product;


}
