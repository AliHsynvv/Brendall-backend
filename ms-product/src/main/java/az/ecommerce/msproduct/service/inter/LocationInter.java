package az.ecommerce.msproduct.service.inter;

import az.ecommerce.msproduct.dto.request.LocationDto;
import az.ecommerce.msproduct.dto.response.LocationResp;
import az.ecommerce.msproduct.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationInter {

    void create(LocationDto locationDto);
    LocationResp findById(long id);
    List<LocationResp> getAllLocations();
    void delete(long id);

    void update(LocationDto locationDto, long id);

}
