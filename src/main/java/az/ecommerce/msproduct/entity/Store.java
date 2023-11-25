package az.ecommerce.msproduct.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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
    String storeIcon;
    String storeLocation;

    @ManyToMany(mappedBy = "storeList")
    List<Product> productList;



}
