package az.ecommerce.msproduct.controller;

import az.ecommerce.msproduct.dto.request.ColourDto;
import az.ecommerce.msproduct.dto.response.ColourResp;
import az.ecommerce.msproduct.entity.Colour;
import az.ecommerce.msproduct.service.inter.ColourInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colour")
@RequiredArgsConstructor
public class ColourController {

    private final ColourInter colourInter;

    @PostMapping("/create")
    public void create(@RequestBody ColourDto colourDto) {
        colourInter.create(colourDto);
    }

    @GetMapping("/findcolour/{id}")
    public ColourResp findById(@PathVariable long id) {
        return colourInter.findById(id);
    }

    @GetMapping("/findcolourbyproductid/{id}")
    public List<ColourResp> findColourByProductId(@PathVariable long id){
        return colourInter.findColourByProductId(id);
    }

    @GetMapping("/findall")
    public List<ColourResp> getAllColours() {
        return colourInter.getAllColours();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        colourInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody ColourDto colourDto, @PathVariable long id) {
         colourInter.update(colourDto, id);
    }
}
