package az.commerce.msfavproducts.service.impl;

import az.commerce.msfavproducts.client.ProductClient;
import az.commerce.msfavproducts.entity.FavProduct;
import az.commerce.msfavproducts.model.client.ProductDto;
import az.commerce.msfavproducts.service.inter.FavProductInter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FavProductImpl implements FavProductInter {

    private final ProductClient productClient;
    private final ModelMapper modelMapper;

    @Override
    public void addFavProduct(FavProduct favProduct,Long productId) {
        ProductDto productDto = productClient.getProductById(productId);
    }

    @Override
    public FavProduct findFavProduct(Long id) {
        return null;
    }

    @Override
    public List<FavProduct> getAllFavProducts() {
        return null;
    }

    @Override
    public void deleteFavProduct(Long id) {

    }
}
