package az.ecommerce.msproduct.controller;

import az.ecommerce.msproduct.dto.request.PriceDto;
import az.ecommerce.msproduct.dto.request.StoreDto;
import az.ecommerce.msproduct.entity.Price;
import az.ecommerce.msproduct.entity.Store;
import az.ecommerce.msproduct.service.inter.StoreInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreInter storeInter;

    @PostMapping("/create")
    public void create(@RequestParam MultipartFile file, @RequestBody StoreDto storeDto) {
        storeInter.create(file, storeDto);
    }

    @GetMapping("/findstore/{id}")
    public StoreDto findById(@PathVariable long id) {
        return storeInter.findById(id);
    }

    @GetMapping("/findall")
    public List<StoreDto> getAllStores() {
        return storeInter.getAllStores();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        storeInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public Store update(@RequestBody StoreDto storeDto, @PathVariable long id) {
        return storeInter.update(storeDto, id);
    }
}
