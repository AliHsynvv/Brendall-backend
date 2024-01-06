package az.commerce.msfavproducts.client;

import az.commerce.msfavproducts.model.client.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ms-product", url = "${client.ms-product.endpoint}")
public interface ProductClient {
    @GetMapping("/products")
    ProductDto getProductById(@PathVariable Long productId);
}
