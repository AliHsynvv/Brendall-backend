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
public class Colour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colourId;
    private String colourName;

    @ManyToOne
    private Product product;

}
