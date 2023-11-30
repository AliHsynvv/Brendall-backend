package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.GenderDto;
import az.ecommerce.msproduct.entity.Gender;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.GenderException;
import az.ecommerce.msproduct.repository.GenderRepo;
import az.ecommerce.msproduct.service.inter.GenderInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class GenderImpl implements GenderInter {

    private final GenderRepo genderRepo;
    private final ModelMapper modelMapper;


    @Override
    public void create(GenderDto genderDto) {
        log.info("Create.service started");
        Gender gender = Gender.builder()
                .name(genderDto.getName())
                .products(genderDto.getProducts())
                .build();
        genderRepo.save(gender);
        log.info("Created.service successed");
    }

    @Override
    public GenderDto findById(long id) {
        log.info("FindById.service started");
        Optional<Gender> findG = genderRepo.findById(id);
        if (findG.isEmpty()) {
            throw new GenderException(ErrorCodeEnum.GENDER_NOT_FOUND);
        }
        log.info("FindById.service successed");
        return findG.map(gender -> modelMapper.map(gender, GenderDto.class)).orElseThrow();
    }

    @Override
    public List<GenderDto> getAllGenders() {
        log.info("GetAllGenders.service started");
        List<Gender> getAllGenders = genderRepo.findAll();
        if (getAllGenders.isEmpty()) {
            throw new GenderException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllGenders.service successed");
        return getAllGenders.stream()
                .map(genders -> modelMapper.map(genders, GenderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<Gender> deleteG = genderRepo.findById(id);
        if (deleteG.isEmpty()) {
            throw new GenderException(ErrorCodeEnum.GENDER_NOT_FOUND);
        } else {
            genderRepo.deleteById(id);
        }
        log.info("Delete.service successed");
    }

    @Override
    public Gender update(GenderDto genderDto, long id) {
        log.info("Update.service started");
        Optional<Gender> updateG = genderRepo.findById(id);
        if (updateG.isPresent()) {
            Gender newGender = updateG.get();
            newGender.setName(genderDto.getName());
            newGender.setProducts(genderDto.getProducts());

            return genderRepo.save(newGender);
        }
        log.info("Update.service successed");
        throw new GenderException(ErrorCodeEnum.NOT_ENOUGH_GENDER);
    }
}
