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
    Long productId;
    String productName;
    @NotBlank(message = "description cannot be empty")
    String description;
    boolean isActivated;
    boolean isDeleted;

    @OneToMany
    @JoinTable(
            name = "colour_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "colourId"))
    List<Colour> colourList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    Price price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id")
    Discount discount;

    @OneToMany(targetEntity = FeedBack.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "feedd_id",referencedColumnName = "productId")
    List<FeedBack> feedBackList;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    Gender gender;

    @ManyToMany
    @JoinTable(
            name = "category_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    List<Category> categoryList;

    @OneToMany
    @JoinTable(
            name = "size_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "sizeId"))
    List<Size> sizeList;

    @ManyToMany
    @JoinTable(
            name = "store_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "storeId"))
    List<Store> storeList;

    @OneToMany(targetEntity = FileData.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id",referencedColumnName = "productId")
    List<FileData> fileData;

    @OneToMany(targetEntity = ImageData.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id",referencedColumnName = "productId")
    List<ImageData> imageDataList;



}
