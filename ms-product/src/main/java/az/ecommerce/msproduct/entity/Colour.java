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
public class Colour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "colour_id")
    long colourId;
    String colourName;

    @ManyToMany
    List<Product> productList;
=======
    private Long colourId;
    private String colourName;

    @ManyToOne
    private Product product;
>>>>>>> origin/Qiyas

}
