package com.dv.controllers;

import com.dv.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diosvo
 */
@RestController
@RequestMapping("/api")
public class ApiProductController {

    @Autowired
    private ProductService productService;

    @DeleteMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable(name = "productId") int productId) {
        this.productService.deleteProduct(productId);
    }
}
