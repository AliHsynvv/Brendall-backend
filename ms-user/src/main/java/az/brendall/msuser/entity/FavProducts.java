package az.brendall.msuser.entity;

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
public class FavProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long favProductsId;
    long productId;
    @ManyToOne
    User user;

}
