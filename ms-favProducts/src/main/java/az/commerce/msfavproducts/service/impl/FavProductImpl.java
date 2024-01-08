package az.commerce.msfavproducts.service.impl;

import az.commerce.msfavproducts.client.ProductClient;
import az.commerce.msfavproducts.dto.request.FavProductDto;
import az.commerce.msfavproducts.entity.FavProduct;
import az.commerce.msfavproducts.enums.ErrorCodeEnum;
import az.commerce.msfavproducts.exception.FavProductException;
import az.commerce.msfavproducts.exception.NotFoundException;
import az.commerce.msfavproducts.model.client.ProductDto;
import az.commerce.msfavproducts.repository.FavProductRepo;
import az.commerce.msfavproducts.service.inter.FavProductInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static az.commerce.msfavproducts.enums.ErrorCodeEnum.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class FavProductImpl implements FavProductInter {

    private final FavProductRepo favProductRepo;
    private final ProductClient productClient;
    private final ModelMapper modelMapper;

    @Override
    public void addFavProduct(ProductDto ProductDto) {
        log.info("addFavProduct started");
        FavProduct favProduct = FavProduct.builder()
                .isActivated(true)
                .isDeleted(false)
                .productId(ProductDto.getProductId())
                .build();
        favProductRepo.save(favProduct);
        log.info("addFavProduct success");

    }

    @Override
    public FavProductDto findFavProduct(Long id) {
        log.info("FindById.service started");
        Optional<FavProduct> findF = favProductRepo.findById(id);
        if (findF.isEmpty()) {
            throw new FavProductException(ErrorCodeEnum.FAVPRODUCT_NOT_FOUND);
        }
        log.info("FindById.service success");
        return findF.map(favE -> modelMapper.map(favE, FavProductDto.class)).orElseThrow();

    }

    @Override
    public List<FavProductDto> getAllFavProducts() {
        log.info("GetAllFavProducts.service started");

        List<FavProduct> getAllFavProducts = favProductRepo.findAll();
        if (getAllFavProducts.isEmpty()) {
            throw new FavProductException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllFavProducts.service success");
        return getAllFavProducts.stream()
                .map(favProducts -> modelMapper.map(favProducts, FavProductDto.class))
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public void deleteFavProduct(Long id) {
        log.info("Delete.service started");
        Optional<FavProduct> deleteF = favProductRepo.findById(id);
        if (deleteF.isEmpty()) {
            throw new FavProductException(ErrorCodeEnum.FAVPRODUCT_NOT_FOUND);
        } else {
            favProductRepo.deleteById(id);
        }
        log.info("Delete.service success");
    }

    @Override
    @Transactional
    public void updateFavProduct(FavProductDto favProductDto, Long id) {
        log.info("Update.service started");
        Optional<FavProduct> updateF = favProductRepo.findById(id);
        if (updateF.isPresent()) {
            FavProduct newFav = updateF.get();
            newFav.setProductId(favProductDto.getProductId());
            newFav.isActivated();
            newFav.isDeleted();

            favProductRepo.save(newFav);
        }
        log.info("Update.service success");

    }
}