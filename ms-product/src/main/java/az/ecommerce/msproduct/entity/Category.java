package az.ecommerce.msproduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Data
@Builder
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Category> subCategory;

    @ManyToOne
    @JsonBackReference
    @Nullable
    private Category parentCategory;

    @ManyToMany(mappedBy = "categoryList")
    private List<Product> productList;

}
