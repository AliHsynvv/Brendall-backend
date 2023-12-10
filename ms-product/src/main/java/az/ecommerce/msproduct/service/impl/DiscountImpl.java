package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.DiscountDto;
import az.ecommerce.msproduct.entity.Discount;
import az.ecommerce.msproduct.entity.Product;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.DiscountException;
import az.ecommerce.msproduct.repository.DiscountRepo;
import az.ecommerce.msproduct.repository.ProductRepo;
import az.ecommerce.msproduct.service.inter.DiscountInter;
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
public class DiscountImpl implements DiscountInter {
    private final ProductRepo productRepo;
    private final DiscountRepo discountRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(DiscountDto discountDto) {
        log.info("Create.service started");

        Optional<Product> existingProduct = productRepo.findById(discountDto.getProductId());
        Product product = existingProduct.orElseThrow(() ->
                new IllegalArgumentException("Product not found for ID: " + discountDto.getProductId()));

        Discount discount = Discount.builder()
                .percentage(discountDto.getPercentage())
                .startDate(discountDto.getStartDate())
                .endDate(discountDto.getEndDate())
                .product(product)
                .build();
        discountRepo.save(discount);
        log.info("Created.service success");
    }

    @Override
    public DiscountDto findById(long id) {
        log.info("FindById.service started");
        Optional<Discount> findD = discountRepo.findById(id);
        if (findD.isEmpty()) {
            throw new DiscountException(ErrorCodeEnum.DISCOUNT_NOT_FOUND);
        }
        log.info("FindById.service success");
        return findD.map(discount -> modelMapper.map(discount, DiscountDto.class)).orElseThrow();
    }

    @Override
    public List<DiscountDto> getAllDiscounts() {
        log.info("GetAllDiscounts.service started");
        List<Discount> getAllDiscounts = discountRepo.findAll();
        if (getAllDiscounts.isEmpty()) {
            throw new DiscountException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllColours.service success");
        return getAllDiscounts.stream()
                .map(discounts -> modelMapper.map(discounts, DiscountDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<Discount> deleteD = discountRepo.findById(id);
        if (deleteD.isEmpty()) {
            throw new DiscountException(ErrorCodeEnum.DISCOUNT_NOT_FOUND);
        } else {
            discountRepo.deleteById(id);
        }
        log.info("Delete.service success");
    }

    @Override
    @Transactional
    public Discount update(DiscountDto discountDto, long id) {
        log.info("Update.service started");
        Optional<Discount> updateD = discountRepo.findById(id);
        if (updateD.isPresent()) {
            Discount newDiscount = updateD.get();
            newDiscount.setPercentage(discountDto.getPercentage());
            newDiscount.setStartDate(discountDto.getStartDate());
            newDiscount.setEndDate(discountDto.getEndDate());

            return discountRepo.save(newDiscount);
        }
        log.info("Update.service success");
        throw new DiscountException(ErrorCodeEnum.NOT_ENOUGH_DISCOUNT);
    }
}
