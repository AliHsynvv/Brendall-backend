package az.ecommerce.msproduct.controller;

import az.ecommerce.msproduct.dto.request.LocationDto;
import az.ecommerce.msproduct.dto.response.LocationResp;
import az.ecommerce.msproduct.entity.Location;
import az.ecommerce.msproduct.service.inter.LocationInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {

private final LocationInter locationInter;
    @PostMapping("/create")
    public void create(@RequestBody LocationDto locationDto) {
        locationInter.create(locationDto);
    }

    @GetMapping("/findlocation/{id}")
    public LocationResp findById(@PathVariable long id) {
        return locationInter.findById(id);
    }

    @GetMapping("/findall")
    public List<LocationResp> getAllColours() {
        return locationInter.getAllLocations();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        locationInter.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody LocationDto locationDto, @PathVariable long id) {
         locationInter.update(locationDto, id);
    }
}
