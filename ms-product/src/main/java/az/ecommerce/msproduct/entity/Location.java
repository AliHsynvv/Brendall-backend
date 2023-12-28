package az.ecommerce.msproduct.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    long locationId;
=======

    private Long locationId;
>>>>>>> origin/Qiyas

    private double latitude;
    private double longitude;

    @ManyToOne
    private Store store;


}
