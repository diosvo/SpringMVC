package com.dv.service.impl;

import com.dv.pojo.Cart;
import com.dv.service.OrderService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author diosvo
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderService orderService;

    @Override
    public boolean addOrder(Map<Integer, Cart> cart) {
        return this.orderService.addOrder(cart);
    }

}
