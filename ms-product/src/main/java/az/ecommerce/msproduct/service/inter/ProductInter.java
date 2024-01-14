package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.response.ProductResp;
import az.ecommerce.msproduct.dto.request.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductInter {
    void create( ProductDto productDto);

    ProductResp findById(long id);

    List<ProductResp> getAllProducts();

    void delete(long id);

    void update(ProductDto productDto, long id);

}
