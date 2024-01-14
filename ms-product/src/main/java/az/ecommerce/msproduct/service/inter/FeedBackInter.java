package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.CategoryDto;
import az.ecommerce.msproduct.dto.request.FeedBackDto;
import az.ecommerce.msproduct.dto.response.DiscountResp;
import az.ecommerce.msproduct.dto.response.FeedBackResp;
import az.ecommerce.msproduct.entity.Category;
import az.ecommerce.msproduct.entity.FeedBack;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedBackInter {

    void create(FeedBackDto feedBackDto);
    FeedBackResp findById(long id);
    List<FeedBackResp> getAllFeedBack();
    void delete(long id);
    void update(FeedBackDto feedBackDto, long id);

}
