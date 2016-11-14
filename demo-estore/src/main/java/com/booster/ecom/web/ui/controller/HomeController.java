package com.booster.ecom.web.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booster.ecom.model.entity.Image;
import com.booster.ecom.service.ImageService;

@Controller
public class HomeController {

    private ImageService imageService;

    @Autowired
    public HomeController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(Model model, Pageable pageable) {

        Page<Image> page = imageService.findPage(pageable);
        model.addAttribute("page", page);

        return "index";
    }

}
