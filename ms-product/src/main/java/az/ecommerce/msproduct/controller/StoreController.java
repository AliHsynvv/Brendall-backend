package az.ecommerce.msproduct.controller;

import az.ecommerce.msproduct.dto.request.PriceDto;
import az.ecommerce.msproduct.dto.request.StoreDto;
import az.ecommerce.msproduct.dto.response.StoreResp;
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
    public void create( @RequestBody StoreDto storeDto) {
        storeInter.create(storeDto);
    }

    @GetMapping("/findstore/{id}")
    public StoreResp findById(@PathVariable long id) {
        return storeInter.findById(id);
    }

    @GetMapping("/findstorebyproductid/{id}")
    public List<StoreResp> findStoreByProductId(@PathVariable long id) {
        return storeInter.findStoreByProductId(id);
    }

    @GetMapping("/findall")
    public List<StoreResp> getAllStores() {
        return storeInter.getAllStores();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        storeInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody StoreDto storeDto, @PathVariable long id) {
         storeInter.update(storeDto, id);
    }
}
