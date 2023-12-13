package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.CategoryDto;
import az.ecommerce.msproduct.dto.request.FeedBackDto;
import az.ecommerce.msproduct.entity.Category;
import az.ecommerce.msproduct.entity.FeedBack;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedBackInter {

    void create(FeedBackDto feedBackDto);
    FeedBackDto findById(long id);
    List<FeedBackDto> getAllFeedBack();
    void delete(long id);
    FeedBack update(FeedBackDto feedBackDto, long id);

}
