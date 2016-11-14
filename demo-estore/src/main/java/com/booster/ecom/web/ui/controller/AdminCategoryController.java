package com.booster.ecom.web.ui.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.booster.ecom.model.entity.Category;
import com.booster.ecom.service.CatalogService;

@Controller
@RequestMapping(value = "/admin/category")
public class AdminCategoryController implements HandlerExceptionResolver {

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(value = "/list")
    public String listCategories(Model uiModel) {
        uiModel.addAttribute("category", new Category());
        uiModel.addAttribute("categoryList", catalogService.listCategories());
        return "admin/categoryList";
    }

    @RequestMapping(value = "/saveCat", method = RequestMethod.POST)
    @PostMapping
    public String saveCat(@Valid Category category, BindingResult bindingResult, @RequestParam("imageFile") MultipartFile file, Model uiModel)
        throws IOException {

        if (bindingResult.hasErrors()) {
            return "redirect:/admin/category/list";
        }

        if (!file.isEmpty()) {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            System.out.println("---" + bufferedImage.getHeight());
            System.out.println("---" + bufferedImage.getWidth());
            System.out.println("---" + bufferedImage.getType());
            category.setImage(file.getBytes());
            category.setImageName(file.getOriginalFilename());
        }
        catalogService.addCategory(category);
        return "redirect:/admin/category/list";
    }
    
    @RequestMapping(value="/delete/{categoryId}")
    public String deleteCategory(@PathVariable(value="categoryId") Long categoryId, Model uiModel) {
        catalogService.deleteCategory(categoryId);
        return "redirect:/admin/category/list";
    }
    
    @RequestMapping(value="/edit/{categoryId}")
    public String editCategory(@PathVariable("categoryId") Long categoryId, Model uiModel) {
        uiModel.addAttribute("category", catalogService.getCategory(categoryId));
        uiModel.addAttribute("categoryList", catalogService.listCategories());
        
        return "admin/categoryList";
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception exception) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("category", new Category());
        mv.addObject("categoryList", catalogService.listCategories());

        mv.addObject("exception", exception.toString());
        mv.setViewName("admin/categoryList");
        return mv;
    }
}
