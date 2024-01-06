package az.commerce.msfavproducts.service.inter;

import az.commerce.msfavproducts.entity.FavProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavProductInter {
    void addFavProduct(FavProduct favProduct, Long productId);
    FavProduct findFavProduct(Long id);
    List<FavProduct> getAllFavProducts();
    void deleteFavProduct(Long id);

}
