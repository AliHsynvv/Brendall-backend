package az.ecommerce.msproduct.entity;


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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long productId;
    String productName;
    String description;
    String productIcons;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pia_fk")
    IsActive isActive;

    @OneToMany(targetEntity = Colour.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fk",referencedColumnName = "productId")
    List<Colour> colourList;

    @OneToMany(targetEntity = Price.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pp_fk",referencedColumnName = "productId")
    List<Price> priceList;

    @OneToMany(targetEntity = Discount.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pd_fk",referencedColumnName = "productId")
    List<Discount> discountList;

    @OneToMany(targetEntity = FeedBack.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pf_fk",referencedColumnName = "productId")
    List<FeedBack> feedBackList;

    @ManyToMany
    @JoinTable(
            name = "product_store",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "storeId"))
    List<Store> storeList;




}
