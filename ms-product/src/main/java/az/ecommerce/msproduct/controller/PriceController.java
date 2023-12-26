package az.ecommerce.msproduct.controller;


import az.ecommerce.msproduct.dto.request.PriceDto;
import az.ecommerce.msproduct.entity.Price;
import az.ecommerce.msproduct.service.inter.PriceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
public class PriceController {
    private final PriceInter priceInter;

    @PostMapping("/create")
    public void create(@RequestBody PriceDto priceDto) {
       priceInter.create(priceDto);
    }

    @GetMapping("/findprice/{id}")
    public PriceDto findById(@PathVariable long id) {
        return priceInter.findById(id);
    }

    @GetMapping("/findall")
    public List<PriceDto> getAllPrices() {
        return priceInter.getAllPrices();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        priceInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody PriceDto priceDto, @PathVariable long id) {
         priceInter.update(priceDto, id);
    }
}
