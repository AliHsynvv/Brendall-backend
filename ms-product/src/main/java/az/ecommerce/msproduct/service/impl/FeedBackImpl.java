package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.request.FeedBackDto;
import az.ecommerce.msproduct.entity.FeedBack;
import az.ecommerce.msproduct.enums.ErrorCodeEnum;
import az.ecommerce.msproduct.exception.FeedBackException;
import az.ecommerce.msproduct.repository.FeedBackRepo;
import az.ecommerce.msproduct.service.inter.FeedBackInter;
import jakarta.transaction.Transactional;
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
public class FeedBackImpl implements FeedBackInter {

    private final FeedBackRepo feedBackRepo;
    private final ModelMapper modelMapper;
    @Override
    public void create(FeedBackDto feedBackDto) {
        log.info("Create.service started");
        FeedBack feedBack = FeedBack.builder()
                .feedRank(feedBackDto.getFeedRank())
                .build();
        feedBackRepo.save(feedBack);
        log.info("Created.service success");

    }

    @Override
    public FeedBackDto findById(long id) {
        log.info("FindById.service started");
        Optional<FeedBack> findF = feedBackRepo.findById(id);
        if (findF.isEmpty()){
            throw new FeedBackException(ErrorCodeEnum.FEEDBACK_NOT_FOUND);

        } log.info("FindById.service success");

        return findF.map(feedBack -> modelMapper.map(feedBack, FeedBackDto.class)).orElseThrow();
    }

    @Override
    public List<FeedBackDto> getAllFeedBack() {
        log.info("GetAllGenders.service started");
        List<FeedBack> getAllFeedBack = feedBackRepo.findAll();
        if (getAllFeedBack.isEmpty()){
            throw new FeedBackException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        log.info("GetAllGenders.service success");
        return getAllFeedBack.stream().map(feedBack -> modelMapper.map(feedBack, FeedBackDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(long id) {
        log.info("Delete.service started");
        Optional<FeedBack> deleteF = feedBackRepo.findById(id);
        if (deleteF.isEmpty()){
            throw new FeedBackException(ErrorCodeEnum.FEEDBACK_NOT_FOUND);
        } else {
            feedBackRepo.deleteById(id);
        }
        log.info("Delete.service success");
    }

    @Override
    @Transactional
    public FeedBack update(FeedBackDto feedBackDto, long id) {
        log.info("Update.service started");
        Optional<FeedBack> updateF = feedBackRepo.findById(id);
        if (updateF.isPresent()){
            FeedBack newFeedBack = updateF.get();
            newFeedBack.setFeedRank(feedBackDto.getFeedRank());
            return feedBackRepo.save(newFeedBack);
        }
        log.info("Update.service success");
        throw new FeedBackException(ErrorCodeEnum.NOT_ENOUGH_FEEDBACK);
    }
}
