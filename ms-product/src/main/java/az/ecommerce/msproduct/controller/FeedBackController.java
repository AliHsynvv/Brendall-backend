package az.ecommerce.msproduct.controller;

import az.ecommerce.msproduct.dto.request.CategoryDto;
import az.ecommerce.msproduct.dto.request.FeedBackDto;
import az.ecommerce.msproduct.dto.response.FeedBackResp;
import az.ecommerce.msproduct.entity.Category;
import az.ecommerce.msproduct.entity.FeedBack;
import az.ecommerce.msproduct.service.inter.CategoryInter;
import az.ecommerce.msproduct.service.inter.FeedBackInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feed")
public class FeedBackController {
    private final FeedBackInter feedBackInter;

    @PostMapping("/create")
    public void create(@RequestBody FeedBackDto feedBackDto) {
        feedBackInter.create(feedBackDto);
    }

    @GetMapping("/findfeed/{id}")
    public FeedBackResp findById(@PathVariable long id) {
        return feedBackInter.findById(id);
    }

    @GetMapping("/findall")
    public List<FeedBackResp> getAllCategories() {
        return feedBackInter.getAllFeedBack();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        feedBackInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody FeedBackDto feedBackDto, @PathVariable long id) {
        feedBackInter.update(feedBackDto, id);

    }

}
