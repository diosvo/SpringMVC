package com.dv.controllers;

import com.dv.pojo.Cart;
import com.dv.pojo.Product;
import com.dv.service.ProductService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ApiCartController {

    @Autowired
    private ProductService productService;

    @GetMapping("/cart/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void addToCart(@PathVariable(name = "productId") int productId,
            HttpSession session) {

        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        if (cart.containsKey(productId) == true) {// đã có trong giỏ 
            Cart c = cart.get(productId);
            c.setQuantity(c.getQuantity() + 1);
        } else { // chưa có trong giỏ
            Product p = this.productService.getProductById(productId);

            Cart c = new Cart();
            c.setProductId(p.getId());
            c.setProductName(p.getName());
            c.setPrice(p.getPrice());
            c.setQuantity(1);

            cart.put(productId, c);
        }

        session.setAttribute("cart", cart);
    }
}
