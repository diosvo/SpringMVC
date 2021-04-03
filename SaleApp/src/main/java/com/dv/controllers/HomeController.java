package com.dv.controllers;

import com.dv.service.CategoryService;
import com.dv.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author diosvo
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam(name = "cateId", required = false) String cateId) {

        if (cateId == null) {
            model.addAttribute("products", this.productService.getProducts(""));
        } else {
            model.addAttribute("products", this.categoryService.getCategoryId(Integer.parseInt(cateId)).getProducts());
        }
        return "index";
    }
}
