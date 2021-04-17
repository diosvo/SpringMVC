package com.dv.repository;

import com.dv.pojo.Cart;
import java.util.Map;

/**
 *
 * @author diosvo
 */
public interface OrderRepository {
    boolean addOrder(Map<Integer, Cart> cart);
}
