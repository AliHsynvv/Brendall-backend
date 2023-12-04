package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.StoreDto;
import az.ecommerce.msproduct.entity.Store;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.ProductException;
import az.ecommerce.msproduct.exception.SizeException;
import az.ecommerce.msproduct.exception.StoreException;
import az.ecommerce.msproduct.repository.StoreRepo;
import az.ecommerce.msproduct.service.inter.StoreInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreImpl implements StoreInter {

    private final StoreRepo storeRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(MultipartFile multipartFile, StoreDto storeDto) {
        log.info("Create.service started");
        Store store;

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        if (fileName.contains("..")){
            throw new StoreException(ErrorCodeEnum.INVALID_FILE);
        }
        try {
            store = Store.builder()
                    .storeName(storeDto.getStoreName())
                    .storeIcon(Base64.getEncoder().encodeToString(multipartFile.getBytes()))
                    .storeLocation(storeDto.getStoreLocation())
                    .build();
        } catch (IOException e) {
            throw  new StoreException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        storeRepo.save(store);
        log.info("Created.service successed");
    }

    @Override
    public StoreDto findById(long id) {
        log.info("FindById.service started");
        Optional<Store> findSt = storeRepo.findById(id);
        if (findSt.isEmpty()) {
            throw new StoreException(ErrorCodeEnum.STORE_NOT_FOUND);
        }
        log.info("FindById.service successed");
        return findSt.map(findStore-> modelMapper.map(findStore, StoreDto.class)).orElseThrow();
    }

    @Override
    public List<StoreDto> getAllStores() {
        log.info("GetAllCategories.service started");
        List<Store> getAllStore = storeRepo.findAll();
        if (getAllStore.isEmpty()){
            throw new StoreException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllStores.service successed");
        return getAllStores().stream().map(store-> modelMapper.map(store, StoreDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<Store> deleteSt = storeRepo.findById(id);
        if (deleteSt.isEmpty()){
            throw new SizeException(ErrorCodeEnum.STORE_NOT_FOUND);
        } else {
            storeRepo.deleteById(id);
        }
        log.info("Delete.service successed");
    }

    @Override
    @Transactional
    public Store update(StoreDto storeDto, long id) {
        log.info("Update.service started");
        Optional <Store> updateSt = storeRepo.findById(id);
        if (updateSt.isPresent()){
            Store newStore = updateSt.get();
            newStore.setStoreName(storeDto.getStoreName());
            newStore.setStoreIcon(storeDto.getStoreIcon());
            newStore.setStoreLocation(storeDto.getStoreLocation());

            return storeRepo.save(newStore);
        }
        log.info("Update.service successed");
        throw new StoreException(ErrorCodeEnum.NOT_ENOUGH_STORE);
    }
}
