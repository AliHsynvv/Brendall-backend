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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long storeId;

    String storeName;
    @OneToOne
    FileData storeIcon;
    @ManyToMany(mappedBy = "storeList")
    List<Product> productList;



}
