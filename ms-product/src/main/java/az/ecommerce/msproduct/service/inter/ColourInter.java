package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.ColourDto;
import az.ecommerce.msproduct.dto.response.ColourResp;
import az.ecommerce.msproduct.entity.Colour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ColourInter {
    void create(ColourDto colourDto);
    ColourResp findById(long id);
    List<ColourResp> findColourByProductId(long id);
    List<ColourResp> getAllColours();
    void delete(long id);
    void update(ColourDto colourDto, long id);

}
