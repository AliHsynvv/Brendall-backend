package az.ecommerce.msproduct.controller;

import az.ecommerce.msproduct.dto.request.ProductDto;
import az.ecommerce.msproduct.entity.Product;
import az.ecommerce.msproduct.service.inter.ProductInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductInter productInter;

    @PostMapping("/create")
    public void create(@RequestParam MultipartFile file, @RequestBody ProductDto productDto){
        productInter.create(file,productDto);
    }

    @GetMapping("/findproduct/{id}")
    public ProductDto findById(@PathVariable long id){
        return productInter.findById(id);
    }

    @GetMapping("/findall")
    public List<ProductDto> getAllProducts(){
        return productInter.getAllProducts();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id){
        productInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public Product update(@RequestBody ProductDto productDto, @PathVariable long id){
       return productInter.update(productDto,id);

    }


}
