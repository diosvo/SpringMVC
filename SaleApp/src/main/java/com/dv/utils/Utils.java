package com.dv.utils;

import com.dv.pojo.Cart;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author diosvo
 */
public class Utils {

    public static Map<String, BigDecimal> cartStats(Map<Integer, Cart> cart) {
        int totalQuantity = 0;
        BigDecimal totalAmount = new BigDecimal(0);
        if (cart != null) {
            for (Cart c : cart.values()) {
                totalQuantity += c.getQuantity();
                totalAmount = totalAmount.add(c.getPrice()
                        .multiply(new BigDecimal(c.getQuantity())));
            }
        }

        Map<String, BigDecimal> re = new HashMap<>();
        re.put("totalAmount", totalAmount);
        re.put("totalQuantity", new BigDecimal(totalQuantity));

        return re;
    }
}
