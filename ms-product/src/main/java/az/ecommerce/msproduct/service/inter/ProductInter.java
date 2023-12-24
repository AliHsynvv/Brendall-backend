package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.ProductDto;
import az.ecommerce.msproduct.dto.response.ProductResp;
import az.ecommerce.msproduct.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ProductInter {
    void create( ProductResp productResp);

    ProductDto findById(long id);

    List<ProductDto> getAllProducts();

    void delete(long id);

    Product update(ProductResp productResp, long id);

}
