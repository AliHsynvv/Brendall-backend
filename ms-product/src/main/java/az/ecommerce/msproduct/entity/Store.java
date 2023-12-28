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
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    private String storeName;
    @OneToOne
    private FileData storeIcon;

    @ManyToMany
    private List<Product> productList;

    @OneToMany(targetEntity = Location.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "loc_id", referencedColumnName = "StoreId")
    private List<Location> locationList;


}
