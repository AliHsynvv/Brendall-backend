package az.commerce.msfavproducts.model.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long productId;
    private String productName;
    private String description;
    private boolean isActivated;
    private boolean isDeleted;
    private List<Long> colourList;
    private Long price;
    private Long discount;
    private List<Long> feedBackList;
    private List<Long> sizeList;
    private List<Long> storeList;
    private Long gender;
    private  List<Long> categoryList;
    private List<Long> imageDataList;
    private  List<Long> fileDataList;

}
