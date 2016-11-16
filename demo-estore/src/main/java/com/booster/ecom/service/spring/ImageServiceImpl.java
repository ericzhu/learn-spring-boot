package com.booster.ecom.service.spring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hibernate.id.IncrementGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.actuate.metrics.repository.InMemoryMetricRepository;
import org.springframework.boot.actuate.metrics.writer.Delta;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.booster.ecom.constant.ApplicationConstants;
import com.booster.ecom.model.entity.Image;
import com.booster.ecom.repository.db.ImageRepository;
import com.booster.ecom.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository          imageRepository;
    private ResourceLoader           resourceLoader;
    private CounterService           counterService;
    private GaugeService             gaugeService;

    private InMemoryMetricRepository inMemoryMetricRepository;

    private SimpMessagingTemplate    messageTemplate;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository,
        ResourceLoader resourceLoader,
        CounterService counterService,
        GaugeService gaugeService,
        InMemoryMetricRepository inMemoryMetricRepository,
        SimpMessagingTemplate messageTemplate) {

        this.imageRepository = imageRepository;
        this.resourceLoader = resourceLoader;
        this.counterService = counterService;
        this.gaugeService = gaugeService;

        this.counterService.reset("files.uploaded");
        this.gaugeService.submit("files.uploaded.lastByters", 0);
        this.inMemoryMetricRepository = inMemoryMetricRepository;
        this.inMemoryMetricRepository.set(new Metric<Number>("files.uploaded.totalBytes", 0));
        this.messageTemplate = messageTemplate;
    }

    public Resource findOneImage(String filename) {
        return resourceLoader.getResource("file:" + ApplicationConstants.UPLOAD_DIR + "/" + filename);
    }

    public void createImage(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            Files.copy(file.getInputStream(), Paths.get(ApplicationConstants.UPLOAD_DIR, file.getOriginalFilename()));
            imageRepository.save(new Image(file.getOriginalFilename()));
            counterService.increment("files.uploaded");
            gaugeService.submit("files.uploaded.lastByters", file.getSize());
            inMemoryMetricRepository.increment(new Delta<Number>("files.uploaded.totalBytes", file.getSize()));
            messageTemplate.convertAndSend("/topic/newImage", file.getOriginalFilename());
        }
    }

    public void deleteImage(String filename) throws IOException {
        final Image image = imageRepository.findByName(filename);
        imageRepository.delete(image);
        Files.deleteIfExists(Paths.get(ApplicationConstants.UPLOAD_DIR, filename));
        messageTemplate.convertAndSend("/topic/deleteImage", filename);
    }

    @Override
    public Page<Image> findPage(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }
}
