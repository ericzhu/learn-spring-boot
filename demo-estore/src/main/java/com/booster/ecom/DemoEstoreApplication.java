package com.booster.ecom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

import com.booster.ecom.constant.ApplicationConstants;
import com.booster.ecom.constant.Profiles;
import com.booster.ecom.model.entity.Image;
import com.booster.ecom.repository.db.ImageRepository;

@SpringBootApplication
public class DemoEstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEstoreApplication.class, args);
    }

    @Bean
    @Profile(Profiles.DEMO)
    public CommandLineRunner setup(ImageRepository imageRepository) throws IOException {
        return (args) -> {
            FileSystemUtils.deleteRecursively(new File(ApplicationConstants.UPLOAD_DIR));
            Files.createDirectory(Paths.get(ApplicationConstants.UPLOAD_DIR));

            FileCopyUtils.copy("test file1", new FileWriter(ApplicationConstants.UPLOAD_DIR + "/test1"));
            imageRepository.save(new Image("test1"));

            FileCopyUtils.copy("test file2", new FileWriter(ApplicationConstants.UPLOAD_DIR + "/test2"));
            imageRepository.save(new Image("test2"));

            FileCopyUtils.copy("test file3", new FileWriter(ApplicationConstants.UPLOAD_DIR + "/test3"));
            imageRepository.save(new Image("test3"));

        };
    }
}
