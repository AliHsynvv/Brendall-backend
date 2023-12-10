package az.ecommerce.msproduct.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long productId;
    String productName;
    @NotBlank(message = "description cannot be empty")
    String description;
    boolean isActivated;
    boolean isDeleted;

    @OneToMany(targetEntity = Colour.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fk",referencedColumnName = "productId")
    List<Colour> colourList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pp_fk")
    Price price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pd_fk")
    Discount discount;

    @OneToMany(targetEntity = FeedBack.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pf_fk",referencedColumnName = "productId")
    List<FeedBack> feedBackList;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    Gender gender;

    @ManyToMany
    @JoinTable(
            name = "product_catgory",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    List<Category> categoryList;

    @OneToMany(targetEntity = Size.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "psize_fk",referencedColumnName = "productId")
    List<Size> sizeList;

    @ManyToMany
    @JoinTable(
            name = "product_store",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "storeId"))
    List<Store> storeList;

    @OneToMany(targetEntity = FileData.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pfile_fk",referencedColumnName = "productId")
    List<FileData> fileData;

    @OneToMany(targetEntity = ImageData.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pi_fk",referencedColumnName = "productId")
    List<ImageData> imageDataList;



}
