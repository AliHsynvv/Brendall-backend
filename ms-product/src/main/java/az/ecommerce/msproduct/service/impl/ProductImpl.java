package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.response.ProductResp;
import az.ecommerce.msproduct.dto.request.ProductDto;
import az.ecommerce.msproduct.entity.*;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.ProductException;
import az.ecommerce.msproduct.repository.*;
import az.ecommerce.msproduct.service.inter.ProductInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    public void create(ProductDto productDto) {
        log.info("Create.service started");

        Price price = priceRepo.findById(productDto.getPriceId()).orElseThrow(null);

        Discount discount = discountRepo.findById(productDto.getDiscountId()).orElseThrow(null);

        Gender gender = genderRepo.findById(productDto.getGenderId()).orElseThrow(null);

        List<Category> categories = productDto.getCategoryIds().stream()
                .map(categoryId -> categoryRepo.findById(categoryId).orElseThrow())
                .collect(Collectors.toList());

        List<FeedBack> feedBacks = productDto.getFeedIds().stream()
                .map(feedId -> feedBackRepo.findById(feedId).orElseThrow())
                .collect(Collectors.toList());

        List<Colour> colours = productDto.getColourIds().stream()
                .map(colourId -> colourRepo.findById(colourId).orElseThrow())
                .collect(Collectors.toList());

        List<FileData> fileDataList = productDto.getFileIds().stream()
                .map(fileId -> fileDataRepo.findById(fileId).orElseThrow())
                .collect(Collectors.toList());

        List<ImageData> imageDataList = productDto.getImageIds().stream()
                .map(imageId -> imageRepo.findById(imageId).orElseThrow())
                .collect(Collectors.toList());

        List<Store> stores = productDto.getStoreIds().stream()
                .map(storeId -> storeRepo.findById(storeId).orElseThrow())
                .collect(Collectors.toList());

        List<Size> sizes = productDto.getSizeIds().stream()
                .map(sizeId -> sizeRepo.findById(sizeId).orElseThrow())
                .collect(Collectors.toList());

        Product product = Product.builder()
                .productName(productDto.getProductName())
                .description(productDto.getDescription())
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
    public ProductResp findById(long id) {
        log.info("FindById.service started");
        Optional<Product> findP = productRepo.findById(id);
        if (findP.isEmpty()) {
            throw new ProductException(ErrorCodeEnum.PRODUCT_NOT_FOUND);
        }
        log.info("FindById.service success");
        return findP.map(productE -> modelMapper.map(productE, ProductResp.class)).orElseThrow();
    }



    @Override
    public List<ProductResp> getAllProducts() {
        log.info("GetAllProducts.service started");
        List<Product> getAllProducts = productRepo.findAll();
        if (getAllProducts.isEmpty()) {
            throw new ProductException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllProducts.service success");
        return getAllProducts.stream()
                .map(products -> modelMapper.map(products, ProductResp.class))
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
    public void update(ProductDto productDto, long id) {
        log.info("Update.service started");

        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new ProductException(ErrorCodeEnum.PRODUCT_NOT_FOUND));
        existingProduct.setProductName(productDto.getProductName());
        existingProduct.setDescription(productDto.getDescription());

        if (productDto.getPriceId() != null) {
            Price price = priceRepo.findById(productDto.getPriceId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Price not found for ID: " + productDto.getPriceId()));
            existingProduct.setPrice(price);
        }

        if (productDto.getDiscountId() != null) {
            Discount discount = discountRepo.findById(productDto.getDiscountId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Discount not found for ID: " + productDto.getDiscountId()));
            existingProduct.setDiscount(discount);
        }

        if (productDto.getDiscountId() != null) {
            Gender gender = genderRepo.findById(productDto.getGenderId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Gender not found for ID: " + productDto.getGenderId()));
            existingProduct.setGender(gender);
        }


        if (productDto.getSizeIds() != null && !productDto.getSizeIds().isEmpty()) {
            List<Size> sizes = sizeRepo.findAllById(productDto.getSizeIds());
            existingProduct.setSizeList(sizes);
        }

        if (productDto.getColourIds() != null && !productDto.getColourIds().isEmpty()) {
            List<Colour> colours = colourRepo.findAllById(productDto.getColourIds());
            existingProduct.setColourList(colours);
        }
        if (productDto.getCategoryIds() != null && !productDto.getCategoryIds().isEmpty()) {
            List<Category> categories = categoryRepo.findAllById(productDto.getCategoryIds());
            existingProduct.setCategoryList(categories);
        }

        if (productDto.getFeedIds() != null && !productDto.getFeedIds().isEmpty()) {
            List<FeedBack> feedBacks = feedBackRepo.findAllById(productDto.getFeedIds());
            existingProduct.setFeedBackList(feedBacks);
        }
        if (productDto.getFileIds() != null && !productDto.getFileIds().isEmpty()) {
            List<FileData> fileDataList = fileDataRepo.findAllById(productDto.getFileIds());
            existingProduct.setFileDataList(fileDataList);
        }
        if (productDto.getImageIds() != null && !productDto.getImageIds().isEmpty()) {
            List<ImageData> imageDataList = imageRepo.findAllById(productDto.getImageIds());
            existingProduct.setImageDataList(imageDataList);
        }

        if (productDto.getStoreIds() != null && !productDto.getStoreIds().isEmpty()) {
            List<Store> stores = storeRepo.findAllById(productDto.getStoreIds());
            existingProduct.setStoreList(stores);
        }

        log.info("Update.service success");
        productRepo.save(existingProduct);

    }
}
