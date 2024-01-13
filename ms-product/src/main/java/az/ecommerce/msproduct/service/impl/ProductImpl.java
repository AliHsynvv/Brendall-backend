package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.ProductDto;
import az.ecommerce.msproduct.dto.response.ProductResp;
import az.ecommerce.msproduct.entity.*;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.ProductException;
import az.ecommerce.msproduct.repository.*;
import az.ecommerce.msproduct.service.inter.ProductInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductImpl implements ProductInter {
    private final ModelMapper modelMapper;

    private final ProductRepo productRepo;

    private final CategoryRepo categoryRepo;
    private final ColourRepo colourRepo;
    private final DiscountRepo discountRepo;
    private final FeedBackRepo feedBackRepo;
    private final FileDataRepo fileDataRepo;
    private final GenderRepo genderRepo;
    private final ImageRepo imageRepo;
    private final PriceRepo priceRepo;
    private final SizeRepo sizeRepo;
    private final StoreRepo storeRepo;

    @Override
    public void create(ProductResp productResp) {
        log.info("Create.service started");

        Price price = priceRepo.findById(productResp.getPriceId()).orElseThrow(null);

        Discount discount = discountRepo.findById(productResp.getDiscountId()).orElseThrow(null);

        Gender gender = genderRepo.findById(productResp.getGenderId()).orElseThrow(null);

        List<Category> categories = productResp.getCategoryIds().stream()
                .map(categoryId -> categoryRepo.findById(categoryId).orElseThrow())
                .collect(Collectors.toList());

        List<FeedBack> feedBacks = productResp.getFeedIds().stream()
                .map(feedId -> feedBackRepo.findById(feedId).orElseThrow())
                .collect(Collectors.toList());

        List<Colour> colours = productResp.getColourIds().stream()
                .map(colourId -> colourRepo.findById(colourId).orElseThrow())
                .collect(Collectors.toList());

        List<FileData> fileDataList = productResp.getFileIds().stream()
                .map(fileId -> fileDataRepo.findById(fileId).orElseThrow())
                .collect(Collectors.toList());

        List<ImageData> imageDataList = productResp.getImageIds().stream()
                .map(imageId -> imageRepo.findById(imageId).orElseThrow())
                .collect(Collectors.toList());

        List<Store> stores = productResp.getStoreIds().stream()
                .map(storeId -> storeRepo.findById(storeId).orElseThrow())
                .collect(Collectors.toList());

        List<Size> sizes = productResp.getSizeIds().stream()
                .map(sizeId -> sizeRepo.findById(sizeId).orElseThrow())
                .collect(Collectors.toList());

        Product product = Product.builder()
                .productName(productResp.getProductName())
                .description(productResp.getDescription())
                .isActivated(true)
                .isDeleted(false)
                .categoryList(categories)
                .colourList(colours)
                .discount(discount)
                .feedBackList(feedBacks)
                .fileDataList(fileDataList)
                .gender(gender)
                .imageDataList(imageDataList)
                .price(price)
                .sizeList(sizes)
                .storeList(stores)
                .build();

        productRepo.save(product);
        log.info("Created.service success");

    }


    @Override
    public ProductDto findById(long id) {
        log.info("FindById.service started");
        Optional<Product> findP = productRepo.findById(id);
        if (findP.isEmpty()) {
            throw new ProductException(ErrorCodeEnum.PRODUCT_NOT_FOUND);
        }
        log.info("FindById.service success");
        return findP.map(productE -> modelMapper.map(productE, ProductDto.class)).orElseThrow();
    }



    @Override
    public List<ProductDto> getAllProducts() {
        log.info("GetAllProducts.service started");
        List<Product> getAllProducts = productRepo.findAll();
        if (getAllProducts.isEmpty()) {
            throw new ProductException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllProducts.service success");
        return getAllProducts.stream()
                .map(products -> modelMapper.map(products, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<Product> deleteC = productRepo.findById(id);
        if (deleteC.isEmpty()) {
            throw new ProductException(ErrorCodeEnum.PRODUCT_NOT_FOUND);
        } else {
            productRepo.deleteById(id);
        }
        log.info("Delete.service success");
    }


    @Override
    @Transactional
    public void update(ProductResp productResp, long id) {
        log.info("Update.service started");

        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new ProductException(ErrorCodeEnum.PRODUCT_NOT_FOUND));
        existingProduct.setProductName(productResp.getProductName());
        existingProduct.setDescription(productResp.getDescription());

        if (productResp.getPriceId() != null) {
            Price price = priceRepo.findById(productResp.getPriceId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Price not found for ID: " + productResp.getPriceId()));
            existingProduct.setPrice(price);
        }

        if (productResp.getDiscountId() != null) {
            Discount discount = discountRepo.findById(productResp.getDiscountId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Discount not found for ID: " + productResp.getDiscountId()));
            existingProduct.setDiscount(discount);
        }

        if (productResp.getDiscountId() != null) {
            Gender gender = genderRepo.findById(productResp.getGenderId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Gender not found for ID: " + productResp.getGenderId()));
            existingProduct.setGender(gender);
        }


        if (productResp.getSizeIds() != null && !productResp.getSizeIds().isEmpty()) {
            List<Size> sizes = sizeRepo.findAllById(productResp.getSizeIds());
            existingProduct.setSizeList(sizes);
        }

        if (productResp.getColourIds() != null && !productResp.getColourIds().isEmpty()) {
            List<Colour> colours = colourRepo.findAllById(productResp.getColourIds());
            existingProduct.setColourList(colours);
        }
        if (productResp.getCategoryIds() != null && !productResp.getCategoryIds().isEmpty()) {
            List<Category> categories = categoryRepo.findAllById(productResp.getCategoryIds());
            existingProduct.setCategoryList(categories);
        }

        if (productResp.getFeedIds() != null && !productResp.getFeedIds().isEmpty()) {
            List<FeedBack> feedBacks = feedBackRepo.findAllById(productResp.getFeedIds());
            existingProduct.setFeedBackList(feedBacks);
        }
        if (productResp.getFileIds() != null && !productResp.getFileIds().isEmpty()) {
            List<FileData> fileDataList = fileDataRepo.findAllById(productResp.getFileIds());
            existingProduct.setFileDataList(fileDataList);
        }
        if (productResp.getImageIds() != null && !productResp.getImageIds().isEmpty()) {
            List<ImageData> imageDataList = imageRepo.findAllById(productResp.getImageIds());
            existingProduct.setImageDataList(imageDataList);
        }

        if (productResp.getStoreIds() != null && !productResp.getStoreIds().isEmpty()) {
            List<Store> stores = storeRepo.findAllById(productResp.getStoreIds());
            existingProduct.setStoreList(stores);
        }


        log.info("Update.service success");
        productRepo.save(existingProduct);

    }
}
