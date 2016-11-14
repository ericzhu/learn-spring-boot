package com.booster.ecom.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    public Resource findOneImage(String filename);

    public void createImage(MultipartFile file) throws IOException;

    public void deleteImage(String filename) throws IOException;

}
