package com.dv.controllers;

import com.dv.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author diosvo
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/")
    public String addView(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }
}
