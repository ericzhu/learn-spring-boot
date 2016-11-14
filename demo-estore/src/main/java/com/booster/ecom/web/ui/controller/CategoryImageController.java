package com.booster.ecom.web.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.booster.ecom.model.entity.Category;
import com.booster.ecom.service.CatalogService;

@Controller
@RequestMapping(value = "/image")
public class CategoryImageController {

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(value = "/category/{categoryId}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] showCategoryImage(@PathVariable(name = "categoryId") Long categoryId) {
        Category category = catalogService.getCategory(categoryId);
        return category == null ? null : category.getImage();
    }

}
