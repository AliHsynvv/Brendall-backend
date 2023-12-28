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
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeId;
    private String sizeName;

<<<<<<< HEAD
    @ManyToMany
    List<Product> productList;
=======
    @ManyToOne
    private Product product;
>>>>>>> origin/Qiyas


}
