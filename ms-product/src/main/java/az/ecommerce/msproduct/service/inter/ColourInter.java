package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.ColourDto;
import az.ecommerce.msproduct.entity.Colour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ColourInter {
    void create(ColourDto colourDto);
    ColourDto findById(long id);
    List<ColourDto> getAllColours();
    void delete(long id);
    Colour update(ColourDto colourDto, long id);

}
