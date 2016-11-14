package com.booster.ecom.service.spring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.booster.ecom.constant.ApplicationConstants;
import com.booster.ecom.model.entity.Image;
import com.booster.ecom.repository.db.ImageRepository;
import com.booster.ecom.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;
    private ResourceLoader  resourceLoader;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, ResourceLoader resourceLoader) {
        this.imageRepository = imageRepository;
        this.resourceLoader = resourceLoader;
    }

    public Resource findOneImage(String filename) {
        return resourceLoader.getResource("file:" + ApplicationConstants.UPLOAD_DIR + "/" + filename);
    }

    public void createImage(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            Files.copy(file.getInputStream(), Paths.get(ApplicationConstants.UPLOAD_DIR, file.getOriginalFilename()));
            imageRepository.save(new Image(file.getOriginalFilename()));
        }
    }

    public void deleteImage(String filename) throws IOException {
        final Image image = imageRepository.findByName(filename);
        imageRepository.delete(image);
        Files.deleteIfExists(Paths.get(ApplicationConstants.UPLOAD_DIR, filename));
    }

    @Override
    public Page<Image> findPage(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }
}
