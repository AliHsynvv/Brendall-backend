//package az.ecommerce.msproduct.util;
//
//import az.ecommerce.msproduct.dto.request.*;
//import az.ecommerce.msproduct.entity.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ProductConverter {
//
//
//    public static ProductDto convertToDto(Product product) {
//        ProductDto productDto = new ProductDto();
//        productDto.setProductId(product.getProductId());
//        productDto.setProductName(product.getProductName());
//        productDto.setDescription(product.getDescription());
//        productDto.setActivated(product.isActivated());
//        productDto.setDeleted(product.isDeleted());
//        productDto.setColourList(convertColourListToDto(product.getColourList()));
//        productDto.setPrice(convertPriceToDto(product.getPrice()));
//        productDto.setDiscount(convertDiscountToDto(product.getDiscount()));
//        productDto.setFeedBackList(convertFeedBackListToDto(product.getFeedBackList()));
//        productDto.setGender(convertGenderToDto(product.getGender()));
//        productDto.setCategoryList(convertCategoryListToDto(product.getCategoryList()));
//        productDto.setSizeList(convertSizeListToDto(product.getSizeList()));
//        productDto.setStoreList(product.getStoreList());
//        productDto.setFileDataList(product.getFileDataList());
//        productDto.setImageDataList(convertImageDataListToDto(product.getImageDataList()));
//        return productDto;
//    }
//
//    public static List<ProductDto> convertToDtoList(List<Product> productList) {
//        return productList.stream()
//                .map(ProductConverter::convertToDto)
//                .collect(Collectors.toList());
//    }
//
//    private static List<ColourDto> convertColourListToDto(List<Colour> colourList) {
//        return colourList.stream()
//                .map(colour -> new ColourDto(colour.getColourId(), colour.getColourName()))
//                .collect(Collectors.toList());
//    }
//
//    private static PriceDto convertPriceToDto(Price price) {
//        return new PriceDto(price.getPriceId(), price.getAmount());
//    }
//
//    private static DiscountDto convertDiscountToDto(Discount discount) {
//        return new DiscountDto(discount.getId(), discount.getPercentage());
//    }
//
//    private static List<FeedBackDto> convertFeedBackListToDto(List<FeedBack> feedBackList) {
//        return feedBackList.stream()
//                .map(feedBack -> new FeedBackDto(feedBack.getId(), feedBack.getComment()))
//                .collect(Collectors.toList());
//    }
//
//    private static GenderDto convertGenderToDto(Gender gender) {
//        return new GenderDto(gender.getId(), gender.getName());
//    }
//
//    private static List<CategoryDto> convertCategoryListToDto(List<Category> categoryList) {
//        return categoryList.stream()
//                .map(category -> new CategoryDto(category.getId(), category.getName()))
//                .collect(Collectors.toList());
//    }
//
//    private static List<SizeDto> convertSizeListToDto(List<Size> sizeList) {
//        return sizeList.stream()
//                .map(size -> new SizeDto(size.getId(), size.getName()))
//                .collect(Collectors.toList());
//    }
//
//    private static List<ImageDataDto> convertImageDataListToDto(List<ImageData> imageDataList) {
//        return imageDataList.stream()
//                .map(imageData -> new ImageDataDto(imageData.getId(), imageData.getUrl()))
//                .collect(Collectors.toList());
//    }
//}
