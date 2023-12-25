package az.ecommerce.msproduct.dto.request;

import az.ecommerce.msproduct.entity.*;
import lombok.*;

import java.io.File;
import java.util.List;

@Data
public class ProductDto {

    Long productId;
    String productName;
    String description;
    boolean isActivated;
    boolean isDeleted;
    List<ColourDto> colourList;
    PriceDto price;
    DiscountDto discount;
    List<FeedBackDto> feedBackList;
    List<SizeDto> sizeList;
    List<Store> storeList;
    GenderDto gender;
    List<CategoryDto> categoryList;
    List<ImageDataDto> imageDataList;
    List<FileDataDto> fileDataList;


}
