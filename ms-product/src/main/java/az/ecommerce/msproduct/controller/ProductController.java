package az.ecommerce.msproduct.controller;

import az.ecommerce.msproduct.dto.response.ProductResp;
import az.ecommerce.msproduct.dto.request.ProductDto;
import az.ecommerce.msproduct.service.inter.ProductInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductInter productInter;

    @PostMapping("/create")
    public void create(@RequestBody ProductDto productDto) {
        productInter.create(productDto);
    }

    @GetMapping("/findproduct/{id}")
    public ProductResp findById(@PathVariable long id) {
        return productInter.findById(id);
    }



    @GetMapping("/findall")
    public List<ProductResp> getAllProducts() {
        return productInter.getAllProducts();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        productInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody ProductDto productDto, @PathVariable long id) {
        productInter.update(productDto, id);

    }


}
