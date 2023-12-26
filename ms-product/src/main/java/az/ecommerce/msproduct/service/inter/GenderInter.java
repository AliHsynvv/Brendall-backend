package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.GenderDto;
import az.ecommerce.msproduct.entity.Gender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenderInter {
    void create(GenderDto genderDto);
    GenderDto findById(long id);
    List<GenderDto> getAllGenders();
    void delete(long id);
    void update(GenderDto genderDto,long id);
}

