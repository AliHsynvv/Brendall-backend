package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.CategoryDto;
import az.ecommerce.msproduct.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryInter {
    void create(CategoryDto categoryDto);
    CategoryDto findById(long id);
    List<CategoryDto> getAllCategories();
    void delete(long id);
    void update(CategoryDto categoryDto, long id);
}
