package az.ecommerce.msproduct.dto;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
public class ProductDto {


    long productId;
    String productName;
    String description;
    String productIcons;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pia_fk")
    IsActiveDto isActive;

    @OneToMany(targetEntity = ColourDto.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fk",referencedColumnName = "productId")
    List<ColourDto> colourList;

    @OneToMany(targetEntity = PriceDto.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pp_fk",referencedColumnName = "productId")
    List<PriceDto> priceList;

    @OneToMany(targetEntity = DiscountDto.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pd_fk",referencedColumnName = "productId")
    List<DiscountDto> discountList;

    @OneToMany(targetEntity = FeedBackDto.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pf_fk",referencedColumnName = "productId")
    List<FeedBackDto> feedBackList;

    @ManyToMany
    @JoinTable(
            name = "product_store",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "storeId"))
    List<StoreDto> storeList;




}
