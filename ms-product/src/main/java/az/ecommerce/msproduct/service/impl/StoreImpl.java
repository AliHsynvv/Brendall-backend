package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.StoreDto;
import az.ecommerce.msproduct.dto.response.ProductResp;
import az.ecommerce.msproduct.dto.response.StoreResp;
import az.ecommerce.msproduct.entity.FileData;
import az.ecommerce.msproduct.entity.Location;
import az.ecommerce.msproduct.entity.Product;
import az.ecommerce.msproduct.entity.Store;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.SizeException;
import az.ecommerce.msproduct.exception.StoreException;
import az.ecommerce.msproduct.repository.FileDataRepo;
import az.ecommerce.msproduct.repository.LocationRepo;
import az.ecommerce.msproduct.repository.ProductRepo;
import az.ecommerce.msproduct.repository.StoreRepo;
import az.ecommerce.msproduct.service.inter.StoreInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreImpl implements StoreInter {

    private final StoreRepo storeRepo;
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    private final LocationRepo locationRepo;
    @Override
    public void create(StoreDto storeDto) {
        log.info("Create.service started");

        List<Location> locationList = locationRepo.findAllById(storeDto.getLocationList());

        Store store = Store.builder()
                .storeName(storeDto.getStoreName())
                .storeIcon(storeDto.getStoreIcon())
                .locationList(locationList)
                .build();

        storeRepo.save(store);
        log.info("Created.service success");
    }

    @Override
    public StoreResp findById(long id) {
        log.info("FindById.service started");
        Optional<Store> findSt = storeRepo.findById(id);
        if (findSt.isEmpty()) {
            throw new StoreException(ErrorCodeEnum.STORE_NOT_FOUND);
        }
        log.info("FindById.service success");
        return findSt.map(findStore -> modelMapper.map(findStore, StoreResp.class)).orElseThrow();
    }

    @Override
    @Lazy
    public List<StoreResp> findStoreByProductId(long id) {
        Optional<Product> findProduct = productRepo.findById(id);
        ProductResp productResp = findProduct.map(colourE -> modelMapper.map(colourE, ProductResp.class)).orElseThrow();

        return productResp.getStoreList();
    }

    @Override
    public List<StoreResp> getAllStores() {
        log.info("GetAllStores.service started");
        List<Store> getAllStore = storeRepo.findAll();
        if (getAllStore.isEmpty()) {
            throw new StoreException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllStores.service success");
        return getAllStore.stream()
                .map(stores -> modelMapper.map(stores, StoreResp.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<Store> deleteSt = storeRepo.findById(id);
        if (deleteSt.isEmpty()) {
            throw new SizeException(ErrorCodeEnum.STORE_NOT_FOUND);
        } else {
            storeRepo.deleteById(id);
        }
        log.info("Delete.service success");
    }

    @Override
    @Transactional
    public void update(StoreDto storeDto, long id) {
        log.info("Update.service started");
        Optional<Store> updateSt = storeRepo.findById(id);
        if (updateSt.isPresent()) {
            Store newStore = updateSt.get();
            newStore.setStoreName(storeDto.getStoreName());
            newStore.setStoreIcon(storeDto.getStoreIcon());

           storeRepo.save(newStore);
        }
        log.info("Update.service success");

    }
}
