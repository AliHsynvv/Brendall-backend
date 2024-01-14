package az.ecommerce.msproduct.controller;

import az.ecommerce.msproduct.dto.request.DiscountDto;
import az.ecommerce.msproduct.dto.response.DiscountResp;
import az.ecommerce.msproduct.entity.Discount;
import az.ecommerce.msproduct.service.inter.DiscountInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountInter discountInter;
    @PostMapping("/create")
    public void create(@RequestBody DiscountDto discountDto) {
        discountInter.create(discountDto);
    }

    @GetMapping("/finddiscount/{id}")
    public DiscountResp findById(@PathVariable long id) {
        return discountInter.findById(id);
    }

    @GetMapping("/finddiscountbyproductid/{id}")
    public DiscountResp findDiscountByProductId(@PathVariable long id) {
        return discountInter.findDiscountByProductId(id);
    }

    @GetMapping("/findall")
    public List<DiscountResp> getAllDiscounts() {
        return discountInter.getAllDiscounts();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        discountInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody DiscountDto discountDto, @PathVariable long id) {
         discountInter.update(discountDto, id);
    }
}
