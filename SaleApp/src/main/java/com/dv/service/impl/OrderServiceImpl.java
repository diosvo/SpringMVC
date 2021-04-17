package com.dv.service.impl;

import com.dv.pojo.Cart;
import com.dv.repository.OrderRepository;
import com.dv.service.OrderService;
import java.util.Date;
import java.util.List;
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
    private OrderRepository orderRepository;

    @Override
    public boolean addOrder(Map<Integer, Cart> cart) {
        return this.orderRepository.addOrder(cart);
    }

    @Override
    public List<Object[]> getStats(Date fromDate, Date toDate) {
        return this.orderRepository.getStats(fromDate, toDate);
    }
}