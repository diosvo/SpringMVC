package com.dv.service.impl;

import com.dv.pojo.Product;
import com.dv.repository.ProductRepository;
import com.dv.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diosvo
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(String kw) {
        return this.productRepository.getProducts(kw);
    }
}
