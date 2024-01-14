package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.ColourDto;
import az.ecommerce.msproduct.dto.response.ColourResp;
import az.ecommerce.msproduct.dto.response.ProductResp;
import az.ecommerce.msproduct.entity.Category;
import az.ecommerce.msproduct.entity.Colour;
import az.ecommerce.msproduct.entity.Product;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.ColourException;
import az.ecommerce.msproduct.repository.ColourRepo;
import az.ecommerce.msproduct.repository.ProductRepo;
import az.ecommerce.msproduct.service.inter.ColourInter;
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
public class ColourImpl implements ColourInter {

    private final ColourRepo colourRepo;
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(ColourDto colourDto) {
        log.info("Create.service started");

        Colour colour = Colour.builder()
                .colourName(colourDto.getColourName())
                .build();
        colourRepo.save(colour);
        log.info("Created.service success");
    }

    @Override
    public ColourResp findById(long id) {
        log.info("FindById.service started");
        Optional<Colour> findC = colourRepo.findById(id);
        if (findC.isEmpty()) {
            throw new ColourException(ErrorCodeEnum.COLOUR_NOT_FOUND);
        }
        log.info("FindById.service success");
        return findC.map(colourE -> modelMapper.map(colourE, ColourResp.class)).orElseThrow();
    }

    @Override
    @Lazy
    public List<ColourResp> findColourByProductId(long id) {

        Optional<Product> findProduct = productRepo.findById(id);
        ProductResp productResp = findProduct.map(colourE -> modelMapper.map(colourE, ProductResp.class)).orElseThrow();

        return productResp.getColourList();
    }

    @Override
    public List<ColourResp> getAllColours() {
        log.info("GetAllColours.service started");
        List<Colour> getAllColours = colourRepo.findAll();
        if (getAllColours.isEmpty()) {
            throw new ColourException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllColours.service success");
        return getAllColours.stream()
                .map(colours -> modelMapper.map(colours, ColourResp.class))
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<Colour> deleteC = colourRepo.findById(id);
        if (deleteC.isEmpty()) {
            throw new ColourException(ErrorCodeEnum.COLOUR_NOT_FOUND);
        } else {
            colourRepo.deleteById(id);
        }
        log.info("Delete.service success");
    }

    @Override
    @Transactional
    public void update(ColourDto colourDto, long id) {
        log.info("Update.service started");
        Optional<Colour> updateC = colourRepo.findById(id);
        if (updateC.isPresent()) {
            Colour newColour = updateC.get();
            newColour.setColourName(colourDto.getColourName());

            colourRepo.save(newColour);
        }
        log.info("Update.service success");

    }
}
