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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long feedId;

    @Min(value = 1)
    @Max(value = 5)
    double feedRank;

    String feedComment;
    String feedIcon;
    @ManyToOne
    Product product;


}
