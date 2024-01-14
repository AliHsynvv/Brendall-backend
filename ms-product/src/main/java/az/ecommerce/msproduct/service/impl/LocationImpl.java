package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.LocationDto;
import az.ecommerce.msproduct.dto.response.LocationResp;
import az.ecommerce.msproduct.entity.Location;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.LocationException;
import az.ecommerce.msproduct.repository.LocationRepo;
import az.ecommerce.msproduct.service.inter.LocationInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class LocationImpl implements LocationInter {

    private final LocationRepo locationRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(LocationDto locationDto) {

        log.info("Create.service started");

        Location location = Location.builder()
                .latitude(locationDto.getLatitude())
                .longitude(locationDto.getLongitude())
                .build();
        locationRepo.save(location);
        log.info("Created.service success");
    }

    @Override
    public LocationResp findById(long id) {
        log.info("FindById service started");

        Optional<Location> findL = locationRepo.findById(id);
        if (findL.isEmpty()) {
            throw new LocationException(ErrorCodeEnum.LOCATION_NOT_FOUND);
        }
        log.info("FindById service success");
        return findL.map(Loc -> modelMapper.map(Loc, LocationResp.class)).orElseThrow();
    }

    @Override
    public List<LocationResp> getAllLocations() {
        log.info("GetAllLocations.service started");

        List<Location> getAllLoc = locationRepo.findAll();
        if (getAllLoc.isEmpty()) {
            throw new LocationException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllLocations.service success");
        return getAllLoc.stream()
                .map(Loc -> modelMapper.map(Loc, LocationResp.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<Location> deleteL = locationRepo.findById(id);
        if (deleteL.isEmpty()) {
            throw new LocationException(ErrorCodeEnum.LOCATION_NOT_FOUND);
        } else {
            locationRepo.deleteById(id);
        }
        log.info("Delete.service success");
    }

    @Override
    @Transactional
    public void update(LocationDto locationDto, long id) {
        log.info("Update service started");

        Optional<Location> updateL = locationRepo.findById(id);
        if (updateL.isPresent()) {
            Location newLocation = updateL.get();
            newLocation.setLatitude(locationDto.getLatitude());
            newLocation.setLongitude(locationDto.getLongitude());

             locationRepo.save(newLocation);
        }
        log.info("Update.service success");

    }
}
