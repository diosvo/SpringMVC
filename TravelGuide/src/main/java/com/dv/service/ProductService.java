package com.dv.service;

import com.dv.pojo.Product;
import java.util.List;

/**
 *
 * @author diosvo
 */
public interface ProductService {

    List<Product> getProducts(String kw);
}
