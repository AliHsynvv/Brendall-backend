package az.ecommerce.msproduct.controller;

import az.ecommerce.msproduct.dto.request.SizeDto;
import az.ecommerce.msproduct.dto.response.SizeResp;
import az.ecommerce.msproduct.entity.Size;
import az.ecommerce.msproduct.service.inter.SizeInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/size")
public class SizeController {

    private final SizeInter sizeInter;
    @PostMapping("/create")
    public void create(@RequestBody SizeDto sizeDto) {
        sizeInter.create(sizeDto);
    }

    @GetMapping("/findsize/{id}")
    public SizeResp findById(@PathVariable long id) {
        return sizeInter.findById(id);
    }

    @GetMapping("/findall")
    public List<SizeResp> getAllColours() {
        return sizeInter.getAllSizes();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        sizeInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody SizeDto sizeDto, @PathVariable long id) {
         sizeInter.update(sizeDto, id);
    }
}
