package az.ecommerce.msproduct.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genderId;
    private String name;

    @OneToMany(mappedBy = "gender")
    @JsonManagedReference
    private List<Product> productList;

}

