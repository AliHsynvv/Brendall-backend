package az.brendall.msuser.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@Builder
@Table
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long userId;
    String name;
    String surname;
    String email;
    String password;
    @OneToMany(targetEntity = FavProducts.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "uf_fk", referencedColumnName = "favProductsId")
    List<FavProducts> favProductsList;

    @OneToMany(targetEntity = ProductBasket.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "up_fk", referencedColumnName = "productBasketId")
    List<ProductBasket> productBasketList;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;


}
