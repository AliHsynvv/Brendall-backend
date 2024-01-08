package az.commerce.msfavproducts.controller;

import az.commerce.msfavproducts.dto.request.FavProductDto;
import az.commerce.msfavproducts.model.client.ProductDto;
import az.commerce.msfavproducts.service.inter.FavProductInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fav")
@RequiredArgsConstructor
public class FavProductController {

    private final FavProductInter favProductInter;
    @PostMapping("/create")
    public void addFavProduct(@RequestBody ProductDto productDto){
        favProductInter.addFavProduct(productDto);

    }

    @GetMapping("/findfav/{id}")
    public FavProductDto findFavProduct(@PathVariable Long id) {
       return favProductInter.findFavProduct(id);
    }

    @GetMapping("/findall")
    public List<FavProductDto> getAllFavProducts() {
        return favProductInter.getAllFavProducts();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteFavProduct (@PathVariable Long id) {
        favProductInter.deleteFavProduct(id);
    }

    @PutMapping("/update/{id}")
    public void updateFavProduct(@RequestBody FavProductDto favProductDto, @PathVariable Long id) {
        favProductInter.updateFavProduct(favProductDto, id);
    }

}
