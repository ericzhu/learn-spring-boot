package com.booster.ecom.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.booster.ecom.model.entity.Image;

public interface ImageService {

    public Resource findOneImage(String filename);

    public void createImage(MultipartFile file) throws IOException;

    public void deleteImage(String filename) throws IOException;

    public Page<Image> findPage(Pageable pageable);

}
