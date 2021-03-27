package com.dv.controllers;

import com.dv.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author diosvo
 */
@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "WELCOME TO OUR WEBSITE");
        model.addAttribute("categories", this.categoryService.getCategories());

        return "index";
    }
}
