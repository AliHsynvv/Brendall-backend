package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.GenderDto;
import az.ecommerce.msproduct.entity.Gender;
import az.ecommerce.msproduct.entity.Product;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.GenderException;
import az.ecommerce.msproduct.repository.GenderRepo;
import az.ecommerce.msproduct.repository.ProductRepo;
import az.ecommerce.msproduct.service.inter.GenderInter;
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
public class GenderImpl implements GenderInter {
    private final ProductRepo productRepo;
    private final GenderRepo genderRepo;
    private final ModelMapper modelMapper;


    @Override
    public void create(GenderDto genderDto) {
        log.info("Create.service started");
        Gender gender = Gender.builder()
                .name(genderDto.getName())
                .build();
        genderRepo.save(gender);
        log.info("Created.service success");
    }

    @Override
    public GenderDto findById(long id) {
        log.info("FindById.service started");
        Optional<Gender> findG = genderRepo.findById(id);
        if (findG.isEmpty()) {
            throw new GenderException(ErrorCodeEnum.GENDER_NOT_FOUND);
        }
        log.info("FindById.service success");
        return findG.map(gender -> modelMapper.map(gender, GenderDto.class)).orElseThrow();
    }

    @Override
    public List<GenderDto> getAllGenders() {
        log.info("GetAllGenders.service started");
        List<Gender> getAllGenders = genderRepo.findAll();
        if (getAllGenders.isEmpty()) {
            throw new GenderException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllGenders.service success");
        return getAllGenders.stream()
                .map(genders -> modelMapper.map(genders, GenderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<Gender> deleteG = genderRepo.findById(id);
        if (deleteG.isEmpty()) {
            throw new GenderException(ErrorCodeEnum.GENDER_NOT_FOUND);
        } else {
            genderRepo.deleteById(id);
        }
        log.info("Delete.service success");
    }

    @Override
    @Transactional
    public void update(GenderDto genderDto, long id) {
        log.info("Update.service started");
        Optional<Gender> updateG = genderRepo.findById(id);
        if (updateG.isPresent()) {
            Gender newGender = updateG.get();
            newGender.setName(genderDto.getName());

             genderRepo.save(newGender);
        }
        log.info("Update.service success");

    }
}
