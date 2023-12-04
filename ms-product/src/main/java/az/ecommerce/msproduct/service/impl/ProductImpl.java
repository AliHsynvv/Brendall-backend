package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.ProductDto;
import az.ecommerce.msproduct.entity.Product;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.ProductException;
import az.ecommerce.msproduct.repository.ProductRepo;
import az.ecommerce.msproduct.service.inter.ProductInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductImpl implements ProductInter {
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(ProductDto productDto) {
        log.info("Create.service started");

        Product product = Product.builder()
                .description(productDto.getDescription())
                .productName(productDto.getProductName())
                .isActivated(productDto.isActivated())
                .isDeleted(productDto.isDeleted())
                .build();


        productRepo.save(product);
        log.info("Created.service successed");
    }

    @Override
    public ProductDto findById(long id) {
        log.info("FindById.service started");
        Optional<Product> findP = productRepo.findById(id);
        if (findP.isEmpty()) {
            throw new ProductException(ErrorCodeEnum.PRODUCT_NOT_FOUND);
        }
        log.info("FindById.service successed");
        return findP.map(productE -> modelMapper.map(productE, ProductDto.class)).orElseThrow();

    }

    @Override
    public List<ProductDto> getAllProducts() {
        log.info("GetAllProducts.service started");
        List<Product> getAllProducts = productRepo.findAll();
        if (getAllProducts.isEmpty()) {
            throw new ProductException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllProducts.service successed");
        return getAllProducts.stream()
                .map(products -> modelMapper.map(products, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<Product> deleteP = productRepo.findById(id);
        if (deleteP.isEmpty()) {
            throw new ProductException(ErrorCodeEnum.PRODUCT_NOT_FOUND);
        } else {
            productRepo.deleteById(id);
        }
        log.info("Delete.service successed");
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
        log.info("Update.service successed");
        throw new ProductException(ErrorCodeEnum.NOT_ENOUGH_PRODUCT);

    }
}
