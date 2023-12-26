package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.CategoryDto;
import az.ecommerce.msproduct.dto.request.StoreDto;
import az.ecommerce.msproduct.entity.Category;
import az.ecommerce.msproduct.entity.Store;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface StoreInter {
    void create( StoreDto storeDto);
    StoreDto findById(long id);
    List<StoreDto> getAllStores();
    void delete(long id);
    void update(StoreDto storeDto, long id);
}
