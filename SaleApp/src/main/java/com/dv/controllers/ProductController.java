package com.dv.controllers;

import com.dv.pojo.Product;
import com.dv.service.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author diosvo
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String addView(Model model,
            @RequestParam(name = "productId",
                    required = false,
                    defaultValue = "0") int productId) {
        if (productId > 0) {
            model.addAttribute("product", this.productService.getProductById(productId));
        } else {
            model.addAttribute("product", new Product());
        }

        return "product";
    }

    @PostMapping("/add")
    public String addProduct(Model model,
            @ModelAttribute(value = "product") @Valid Product p,
            BindingResult result) {
        if (result.hasErrors()) {
            return "product";
        }

        if (!this.productService.addOrUpdateProduct(p)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "product";
        }

        return "redirect:/";
    }
}
