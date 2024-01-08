package az.commerce.msfavproducts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long favId;
       private Long productId;
       private boolean isActivated;
       private boolean isDeleted;
}
