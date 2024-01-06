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
    Long favId;

}
