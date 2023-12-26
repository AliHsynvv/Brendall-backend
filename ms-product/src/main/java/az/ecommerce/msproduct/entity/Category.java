package az.ecommerce.msproduct.entity;

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
    @OneToMany
    private List<Category> subCategory;

    @ManyToMany(mappedBy = "categoryList")
    private List<Product> productList;

    @Nullable
    private Long parentId;


}
