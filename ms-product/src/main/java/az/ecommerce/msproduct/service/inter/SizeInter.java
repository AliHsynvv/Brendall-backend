package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.ColourDto;
import az.ecommerce.msproduct.dto.request.SizeDto;
import az.ecommerce.msproduct.dto.response.SizeResp;
import az.ecommerce.msproduct.entity.Size;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SizeInter {

    void create(SizeDto sizeDto);
    SizeResp findById(long id);
    List<SizeResp> getAllSizes();
    void delete(long id);
    void update(SizeDto sizeDto, long id);
}
