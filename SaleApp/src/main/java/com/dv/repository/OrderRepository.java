package com.dv.repository;

import com.dv.pojo.Cart;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author diosvo
 */
public interface OrderRepository {

    boolean addOrder(Map<Integer, Cart> cart);

    List<Object[]> getStats(Date fromDate, Date toDate);
}
