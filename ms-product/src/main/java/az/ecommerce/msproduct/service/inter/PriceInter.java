package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.PriceDto;
import az.ecommerce.msproduct.entity.Price;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PriceInter {

    void create(PriceDto priceDto);
    PriceDto findById(long id);
    List<PriceDto> getAllPrices();
    void delete(long id);
    void update(PriceDto priceDto, long id);

}
