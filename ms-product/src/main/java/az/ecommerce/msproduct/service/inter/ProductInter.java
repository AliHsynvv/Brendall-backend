package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.ProductDto;
import az.ecommerce.msproduct.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ProductInter {
    void create(MultipartFile multipartFile, ProductDto productDto);

    ProductDto findById(long id);

    List<ProductDto> getAllProducts();

    void delete(long id);

    Product update(ProductDto productDto, long id);

}
