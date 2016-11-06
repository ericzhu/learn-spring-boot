package com.booster.ecom.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booster.ecom.model.entity.Category;
import com.booster.ecom.service.CatalogService;

@Controller
@RequestMapping(value = "/admin/category")
public class AdminCategoryController {

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(value = "/list")
    public String listCategories(Model uiModel) {
        uiModel.addAttribute("category", new Category());
        uiModel.addAttribute("categoryList", catalogService.listCategories());
        return "admin/categoryList";
    }
}
