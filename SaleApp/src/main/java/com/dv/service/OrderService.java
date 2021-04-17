package com.dv.service;

import com.dv.pojo.Cart;
import java.util.Map;

/**
 *
 * @author diosvo
 */
public interface OrderService {

    boolean addOrder(Map<Integer, Cart> cart);
}
