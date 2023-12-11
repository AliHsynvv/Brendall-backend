package az.ecommerce.msproduct.service.impl;

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
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;
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
        Optional<Price> existingPrice = priceRepo.findById(productDto.getPriceId());
        Price price = existingPrice.orElseThrow(() ->
                new IllegalArgumentException("Price not found for ID: " + productDto.getPriceId()));
        List<Category> categoryList = categoryRepo.findAllById(productDto.getCategoryIds());
        Optional<Discount> existingDiscount = discountRepo.findById(productDto.getDiscountId());
        Discount discount = existingDiscount.orElseThrow(() ->
                new IllegalArgumentException("Discount not found for ID: " + productDto.getDiscountId()));



        Optional<Gender> existingGender = genderRepo.findById(productDto.getGenderId());
        Gender gender = existingGender.orElseThrow(() ->
                new IllegalArgumentException("Gender not found for ID: " + productDto.getGenderId()));


        List<Colour> colourList = colourRepo.findAllById(productDto.getColourIds());
        List<FeedBack> feedBackList = feedBackRepo.findAllById(productDto.getFeedIds());
        List<FileData> fileList = fileDataRepo.findAllById(productDto.getFileIds());
        List<ImageData> imageDataList = imageRepo.findAllById(productDto.getImageIds());
        List<Size> sizeList = sizeRepo.findAllById(productDto.getSizeIds());
        List<Store> storeList = storeRepo.findAllById(productDto.getStoreIds());

        Product product = Product.builder()
                .productName(productDto.getProductName())
                .description(productDto.getDescription())
                .isActivated(true)
                .isDeleted(false)
                .categoryList(categoryList)
                .colourList(colourList)
                .discount(discount)
                .feedBackList(feedBackList)
                .fileData(fileList)
                .gender(gender)
                .imageDataList(imageDataList)
                .price(price)
                .sizeList(sizeList)
                .storeList(storeList)
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
    public Product update(ProductDto productDto, long id) {
        log.info("Update.service started");
        Optional<Product> updateP = productRepo.findById(id);
        if (updateP.isPresent()) {
            Product newProduct = updateP.get();

            newProduct.setDescription(productDto.getDescription());
            newProduct.setProductName(productDto.getProductName());

            return productRepo.save(newProduct);
        }
        log.info("Update.service success");
        throw new ProductException(ErrorCodeEnum.NOT_ENOUGH_PRODUCT);

    }
}
