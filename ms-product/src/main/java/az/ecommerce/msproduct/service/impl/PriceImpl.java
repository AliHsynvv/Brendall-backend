package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.PriceDto;
import az.ecommerce.msproduct.entity.Price;
import az.ecommerce.msproduct.entity.Product;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.PriceException;
import az.ecommerce.msproduct.repository.PriceRepo;
import az.ecommerce.msproduct.repository.ProductRepo;
import az.ecommerce.msproduct.service.inter.PriceInter;
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
public class PriceImpl implements PriceInter {
    private final ProductRepo productRepo;
    private final PriceRepo priceRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(PriceDto priceDto) {

        log.info("Create.service started");

        Price price = Price.builder()
                .amount(priceDto.getAmount())
                .startDate(priceDto.getStartDate())
                .endDate(priceDto.getEndDate())
                .build();

        priceRepo.save(price);
        log.info("Created.service success");
    }

    @Override
    public PriceDto findById(long id) {
        log.info("FindById.service started");
        Optional<Price> findP = priceRepo.findById(id);
        if ((findP.isEmpty())){
            throw new PriceException(ErrorCodeEnum.PRICE_NOT_FOUND);
        }
        log.info("FindById.service success");


        return findP.map(priceE -> modelMapper.map(priceE, PriceDto.class)).orElseThrow();
    }

    @Override
    public List<PriceDto> getAllPrices() {

        log.info("GetAllPrices.service started");
        List<Price> getAllPrice = priceRepo.findAll();
        if (getAllPrice.isEmpty()){
            throw new PriceException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllPrices.service success");
        return getAllPrice.stream().map(prices -> modelMapper.map(prices, PriceDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(long id) {

        log.info("Delete.service started");
        Optional<Price> deleteP = priceRepo.findById(id);
        if (deleteP.isEmpty()){
            throw new PriceException(ErrorCodeEnum.PRICE_NOT_FOUND);
        } else {
            priceRepo.deleteById(id);
        }
        log.info("Delete.service success");
    }

    @Override
    @Transactional
    public void update(PriceDto priceDto, long id) {
        log.info("Update.service started");
       Optional<Price> updateP = priceRepo.findById(id);
       if (updateP.isPresent()) {
           Price newPrice = updateP.get();
           newPrice.setAmount(priceDto.getAmount());
           newPrice.setStartDate(priceDto.getStartDate());
           newPrice.setEndDate(priceDto.getEndDate());
            priceRepo.save(newPrice);
       }
        log.info("Update.service success");


    }
}
