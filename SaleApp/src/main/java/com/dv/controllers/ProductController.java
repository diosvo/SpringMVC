package com.dv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author diosvo
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/")
    public String addView() {
        return "product";
    }
}
