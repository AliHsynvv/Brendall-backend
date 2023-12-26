package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.DiscountDto;
import az.ecommerce.msproduct.entity.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountInter {
    void create(DiscountDto discountDto);
    DiscountDto findById(long id);
    List<DiscountDto> getAllDiscounts();
    void delete(long id);
    void update(DiscountDto discountDto,long id);
}
