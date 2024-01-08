package az.commerce.msfavproducts.service.inter;

import az.commerce.msfavproducts.dto.request.FavProductDto;
import az.commerce.msfavproducts.entity.FavProduct;
import az.commerce.msfavproducts.model.client.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavProductInter {
    void addFavProduct(ProductDto Product);
    FavProductDto findFavProduct(Long id);
    List<FavProductDto> getAllFavProducts();
    void deleteFavProduct(Long id);
    void updateFavProduct(FavProductDto favProductDto, Long id);
}
