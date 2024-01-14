package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.GenderDto;
import az.ecommerce.msproduct.dto.response.GenderResp;
import az.ecommerce.msproduct.entity.Gender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenderInter {
    void create(GenderDto genderDto);
    GenderResp findById(long id);
    List<GenderResp> getAllGenders();
    void delete(long id);
    void update(GenderDto genderDto,long id);
}

