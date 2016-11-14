package com.booster.ecom.web.ui.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.booster.ecom.service.ImageService;

@Controller
public class ImageController {

    public static final String BASE_PATH = "/images";

    public static final String FILE_NAME = "{filename:.+}";

    private ImageService       imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(method = RequestMethod.GET, value = BASE_PATH + "/" + FILE_NAME + "/raw")
    @ResponseBody
    public ResponseEntity<?> oneRawImage(@PathVariable String filename) throws IOException {
        Resource file = imageService.findOneImage(filename);
        return ResponseEntity.ok().contentLength(file.contentLength()).contentType(MediaType.IMAGE_JPEG).body(new InputStreamResource(file.getInputStream()));
    }

    @RequestMapping(method = RequestMethod.POST, value = BASE_PATH)
    public String createFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        try {
            imageService.createImage(file);
            redirectAttributes.addFlashAttribute("flash.message", "successfully uploaded " + file.getOriginalFilename());
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("flash.message", "failed to upload " + file.getOriginalFilename());
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = BASE_PATH + "/" + FILE_NAME)
    @ResponseBody
    public ResponseEntity<?> deleteImage(@PathVariable String filename) {

        try {
            imageService.deleteImage(filename);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("successfully deleted " + filename);
        }
        catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to delete " + filename + " => " + e.getMessage());
        }

    }
}
