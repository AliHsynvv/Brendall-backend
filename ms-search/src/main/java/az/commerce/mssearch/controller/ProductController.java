package az.commerce.mssearch.controller;

import az.commerce.mssearch.model.Product;
import az.commerce.mssearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productByName/{name}")
    public List<Product> getProductsByName( @PathVariable(value = "name") String name){
        return productService.findProductsByName(name);
    }
    @GetMapping("/findByInStock/{inStock}")
    public List<Product> findByInStock(@PathVariable boolean inStock){
        return productService.findByInStock(inStock);
    }
    @GetMapping("/findPrice/findByPriceBetween/{minPrice}/{maxPrice}")
    List<Product> findByPriceBetween( @PathVariable BigDecimal minPrice, @PathVariable BigDecimal maxPrice) {
        return productService.findByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/fetchSuggestionsByName/{name}")
    public List<String> fetchSuggestionsByName( @PathVariable(value = "name") String name){
        return productService.fetchSuggestions(name);
    }

    @GetMapping("/fuzzySearch/{name}")
    public List<Product> fuzzySearchByName( @PathVariable(value = "name") String name){
        return productService.fuzzySearch(name);
    }

    @GetMapping("/multiMatchQuery/{name}")
    public List<Product> multiMatchQuery( @PathVariable(value = "name") String name){
        return productService.multiMatchQuery(name);
    }

    @GetMapping("/productByBoolQuery")
    public List<Product> getProductsByBoolQuery( @RequestParam(name = "category") String category,
                                                 @RequestParam(name = "price") BigDecimal price,
                                                 @RequestParam(name = "inStock") Boolean inStock){
        return productService.findProductsByBoolQuery(category,price,inStock);
    }

    @GetMapping("/aggregations")
    public Map<String, Double> multiMatchQuery(){
        return productService.calculateAveragePricePerCategory();
    }
}
