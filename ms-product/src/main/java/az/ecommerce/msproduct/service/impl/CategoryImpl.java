package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.CategoryDto;
import az.ecommerce.msproduct.dto.request.ProductDto;
import az.ecommerce.msproduct.entity.Category;
import az.ecommerce.msproduct.entity.Product;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.CategoryException;
import az.ecommerce.msproduct.exception.ProductException;
import az.ecommerce.msproduct.repository.CategoryRepo;
import az.ecommerce.msproduct.service.inter.CategoryInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryImpl implements CategoryInter {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(CategoryDto categoryDto) {
        log.info("Create.service started");
        Category category = Category.builder()
                .name(categoryDto.getName())
                .build();
        categoryRepo.save(category);
        log.info("Created.service success");
    }

    @Override
    public CategoryDto findById(long id) {
        log.info("FindById.service started");
        Optional<Category> findC = categoryRepo.findById(id);
        if (findC.isEmpty()) {
            throw new CategoryException(ErrorCodeEnum.CATEGORY_NOT_FOUND);
        }
        log.info("FindById.service success");
        return findC.map(categoryE -> modelMapper.map(categoryE, CategoryDto.class)).orElseThrow();
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        log.info("GetAllCategory.service started");

        List<Category> getAllCategories = categoryRepo.findAll();
        if (getAllCategories.isEmpty()) {
            throw new CategoryException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllCategory.service success");
        return getAllCategories.stream()
                .map(categories -> modelMapper.map(categories, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<Category> deleteC = categoryRepo.findById(id);
        if (deleteC.isEmpty()) {
            throw new CategoryException(ErrorCodeEnum.CATEGORY_NOT_FOUND);
        } else {
            categoryRepo.deleteById(id);
        }
        log.info("Delete.service success");
    }

    @Override
    @Transactional
    public Category update(CategoryDto categoryDto, long id) {
        log.info("Update.service started");
        Optional<Category> updateC = categoryRepo.findById(id);
        if (updateC.isPresent()) {
            Category newCategory = updateC.get();
            newCategory.setName(categoryDto.getName());

            return categoryRepo.save(newCategory);
        }
        log.info("Update.service success");
        throw new CategoryException(ErrorCodeEnum.NOT_ENOUGH_CATEGORY);
    }
}
