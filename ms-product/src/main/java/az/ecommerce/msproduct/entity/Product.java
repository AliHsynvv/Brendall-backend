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

<<<<<<< HEAD
<<<<<<< HEAD
    @OneToMany(targetEntity = Colour.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "colourr_id",referencedColumnName = "productId")
=======
    @ManyToMany
=======
    @OneToMany
>>>>>>> origin/Qiyas
    @JoinTable(
            name = "colour_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "colourId"))
<<<<<<< HEAD
>>>>>>> origin/Nicat
    List<Colour> colourList;
=======
    private List<Colour> colourList;
>>>>>>> origin/Qiyas

    @OneToOne
    @JoinColumn(name = "price_id")
    private Price price;

    @OneToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToMany
    @JoinColumn(name = "feedd_id", referencedColumnName = "productId")
    private List<FeedBack> feedBackList;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToMany
    @JoinTable(
            name = "category_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private List<Category> categoryList;

<<<<<<< HEAD
<<<<<<< HEAD
    @OneToMany(targetEntity = Size.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "siz_id",referencedColumnName = "productId")
=======
    @ManyToMany
=======
    @OneToMany
>>>>>>> origin/Qiyas
    @JoinTable(
            name = "size_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "sizeId"))
<<<<<<< HEAD
>>>>>>> origin/Nicat
    List<Size> sizeList;
=======
    private List<Size> sizeList;
>>>>>>> origin/Qiyas

    @ManyToMany
    @JoinTable(
            name = "store_id",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "storeId"))
    private List<Store> storeList;

    @OneToMany
    @JoinColumn(name = "file_id", referencedColumnName = "productId")
    private List<FileData> fileDataList;

    @OneToMany(targetEntity = ImageData.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "productId")
    private List<ImageData> imageDataList;


}
