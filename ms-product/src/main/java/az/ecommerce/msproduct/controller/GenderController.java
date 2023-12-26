package az.ecommerce.msproduct.controller;

import az.ecommerce.msproduct.dto.request.GenderDto;
import az.ecommerce.msproduct.entity.Gender;
import az.ecommerce.msproduct.service.inter.GenderInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gender")
@RequiredArgsConstructor
public class GenderController {
    private final GenderInter genderInter;

    @PostMapping("/create")
    public void create(@RequestBody GenderDto genderDto) {
        genderInter.create(genderDto);
    }

    @GetMapping("/findgender/{id}")
    public GenderDto findById(@PathVariable long id) {
        return genderInter.findById(id);
    }

    @GetMapping("/findall")
    public List<GenderDto> getAllColours() {
        return genderInter.getAllGenders();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        genderInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody GenderDto genderDto, @PathVariable long id) {
         genderInter.update(genderDto, id);
    }

}
