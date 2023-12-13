package az.ecommerce.msproduct.controller;

import az.ecommerce.msproduct.dto.request.CategoryDto;
import az.ecommerce.msproduct.entity.Category;
import az.ecommerce.msproduct.service.inter.CategoryInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryInter categoryInter;

    @PostMapping("/create")
    public void create(@RequestBody CategoryDto categoryDto) {
        categoryInter.create(categoryDto);
    }

    @GetMapping("/findcategory/{id}")
    public CategoryDto findById(@PathVariable long id) {
        return categoryInter.findById(id);
    }

    @GetMapping("/findall")
    public List<CategoryDto> getAllCategories() {
        return categoryInter.getAllCategories();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        categoryInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public Category update(@RequestBody CategoryDto categoryDto, @PathVariable long id) {
        return categoryInter.update(categoryDto, id);
    }
}
