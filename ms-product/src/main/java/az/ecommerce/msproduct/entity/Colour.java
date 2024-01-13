package az.ecommerce.msproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Product product;

}

