package com.dv.repository;

import com.dv.pojo.Product;
import java.util.List;

/**
 *
 * @author diosvo
 */
public interface ProductRepository {

    List<Product> getProducts(String kw);

    boolean deleteProduct(int ProductId);

    boolean addOrUpdateProduct(Product p);

    Product getProductById(int proId);
}
