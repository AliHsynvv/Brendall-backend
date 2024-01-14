package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.PriceDto;
import az.ecommerce.msproduct.dto.response.PriceResp;
import az.ecommerce.msproduct.entity.Price;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PriceInter {

    void create(PriceDto priceDto);
    PriceResp findById(long id);
    PriceResp findPriceByProductId(long id);
    List<PriceResp> getAllPrices();
    void delete(long id);
    void update(PriceDto priceDto, long id);

}
