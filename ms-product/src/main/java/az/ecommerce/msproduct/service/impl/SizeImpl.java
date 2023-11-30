package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.SizeDto;
import az.ecommerce.msproduct.entity.Size;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.SizeException;
import az.ecommerce.msproduct.repository.SizeRepo;
import az.ecommerce.msproduct.service.inter.SizeInter;
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
public class SizeImpl implements SizeInter {

    private final SizeRepo sizeRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(SizeDto sizeDto) {
        log.info("Create.service started");
        Size size = Size.builder()
                .sizeName(sizeDto.getSizeName())
                .product(sizeDto.getProduct())
                .build();
             sizeRepo.save(size);
        log.info("Created.service successed");
    }

    @Override
    public SizeDto findById(long id) {
        log.info("FindById service started");
        Optional<Size> findS = sizeRepo.findById(id);
        if (findS.isEmpty()) {
            throw new SizeException(ErrorCodeEnum.SIZE_NOT_FOUND);
        }
        log.info("FindById service successed");
        return findS.map(sizeE -> modelMapper.map(sizeE, SizeDto.class)).orElseThrow();
    }

    @Override
    public List<SizeDto> getAllSizes() {
        log.info("GetAllSizes.service started");
        List<Size> getAllSize = sizeRepo.findAll();
        if (getAllSize.isEmpty()) {
            throw new SizeException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllSizes.service successed");
        return getAllSize.stream()
                .map(sizes -> modelMapper.map(sizes, SizeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<Size> deleteS = sizeRepo.findById(id);
        if (deleteS.isEmpty()) {
            throw new SizeException(ErrorCodeEnum.SIZE_NOT_FOUND);
        } else {
            sizeRepo.deleteById(id);
        }
        log.info("Delete.service successed");
    }

    @Override
    public Size update(SizeDto sizeDto, long id) {
        log.info("Update service started");
        Optional<Size> updateS = sizeRepo.findById(id);
        if (updateS.isPresent()) {
            Size newSize = updateS.get();
            newSize.setSizeName(sizeDto.getSizeName());
            newSize.setProduct(sizeDto.getProduct());

            return sizeRepo.save(newSize);
        }
        log.info("Update.service successed");
        throw new SizeException(ErrorCodeEnum.NOT_ENOUGH_SIZE);
    }
}
