package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.DiscountDto;
import az.ecommerce.msproduct.dto.response.ColourResp;
import az.ecommerce.msproduct.dto.response.DiscountResp;
import az.ecommerce.msproduct.entity.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountInter {
    void create(DiscountDto discountDto);
    DiscountResp findById(long id);
    DiscountResp findDiscountByProductId(long id);
    List<DiscountResp> getAllDiscounts();
    void delete(long id);
    void update(DiscountDto discountDto,long id);
}
