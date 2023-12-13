package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.ColourDto;
import az.ecommerce.msproduct.dto.request.SizeDto;
import az.ecommerce.msproduct.entity.Size;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SizeInter {

    void create(SizeDto sizeDto);
    SizeDto findById(long id);
    List<SizeDto> getAllSizes();
    void delete(long id);
    Size update(SizeDto sizeDto, long id);
}
