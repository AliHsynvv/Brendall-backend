package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.LocationDto;
import az.ecommerce.msproduct.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationInter {

    void create(LocationDto locationDto);
    LocationDto findById(long id);
    List<LocationDto> getAllLocations();
    void delete(long id);

    Location update(LocationDto locationDto, long id);

}
