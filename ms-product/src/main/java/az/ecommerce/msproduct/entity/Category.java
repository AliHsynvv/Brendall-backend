package az.ecommerce.msproduct.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Table
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long categoryId;
    String name;
    @OneToMany
    List<Category> subCategory;

    @ManyToMany(mappedBy = "categoryList")
    List<Product> productList;

    @Nullable
    long parentId;




}
