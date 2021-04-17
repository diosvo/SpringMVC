package com.dv.service.impl;

import com.dv.pojo.Cart;
import com.dv.service.OrderService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diosvo
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderService orderService;

    @Override
    public boolean addOrder(Map<Integer, Cart> cart) {
        return this.orderService.addOrder(cart);
    }

}
