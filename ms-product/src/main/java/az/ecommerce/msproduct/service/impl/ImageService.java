package az.ecommerce.msproduct.service.impl;

import az.ecommerce.msproduct.dto.response.FileDataResp;
import az.ecommerce.msproduct.dto.response.ImageDataResp;
import az.ecommerce.msproduct.dto.response.ProductResp;
import az.ecommerce.msproduct.dto.response.StoreResp;
import az.ecommerce.msproduct.entity.FileData;
import az.ecommerce.msproduct.entity.ImageData;
import az.ecommerce.msproduct.entity.Product;
import az.ecommerce.msproduct.repository.FileDataRepo;
import az.ecommerce.msproduct.repository.ImageRepo;
import az.ecommerce.msproduct.repository.ProductRepo;
import az.ecommerce.msproduct.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepo imageRepo;
    private final ModelMapper modelMapper;
    private final ProductRepo productRepo;
    private final FileDataRepo fileDataRepo;

    private final String FOLDER_PATH="C:/Users/HP/Desktop/MyFiles/";

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = imageRepo.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }



    public byte[] downloadImage(String fileName) {
        Optional<ImageData> dbImageData = imageRepo.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }


    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData=fileDataRepo.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepo.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

    @Lazy
    public List<ImageDataResp> findImageByProductId(long id) {
        Optional<Product> findProduct = productRepo.findById(id);
        ProductResp productResp = findProduct.map(colourE -> modelMapper.map(colourE, ProductResp.class)).orElseThrow();

        return productResp.getImageDataList();
    }

    @Lazy
    public List<FileDataResp> findFileByProductId(long id) {
        Optional<Product> findProduct = productRepo.findById(id);
        ProductResp productResp = findProduct.map(colourE -> modelMapper.map(colourE, ProductResp.class)).orElseThrow();

        return productResp.getFileDataList();
    }
}
