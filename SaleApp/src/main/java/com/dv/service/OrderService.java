package com.dv.service;

import com.dv.pojo.Cart;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author diosvo
 */
public interface OrderService {

    boolean addOrder(Map<Integer, Cart> cart);
    List<Object[]> getStats(Date fromDate, Date toDate);
}
