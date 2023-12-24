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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    @NotBlank(message = "description cannot be empty")
    private String description;
    private boolean isActivated;
    private boolean isDeleted;

    @OneToMany
    @JoinTable(
            name = "colour_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "colourId"))
    private List<Colour> colourList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private Price price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToMany(targetEntity = FeedBack.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "feedd_id", referencedColumnName = "productId")
    private List<FeedBack> feedBackList;

    @ManyToOne
    @JoinTable(name = "genderId")
    private Gender gender;

    @ManyToMany
    @JoinTable(
            name = "category_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private List<Category> categoryList;

    @OneToMany
    @JoinTable(
            name = "size_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "sizeId"))
    private List<Size> sizeList;

    @ManyToMany
    @JoinTable(
            name = "store_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "storeId"))
    private List<Store> storeList;

    @OneToMany(targetEntity = FileData.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id", referencedColumnName = "productId")
    private List<FileData> fileData;

    @OneToMany(targetEntity = ImageData.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "productId")
    private List<ImageData> imageDataList;


}
