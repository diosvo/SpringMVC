package com.dv.repository.impl;

import com.dv.pojo.Category;
import com.dv.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author diosvo
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public List<Category> getCategories() {
        Category c1 = new Category();
        c1.setId(1);
        c1.setName("Mobile");
        Category c2 = new Category();
        c2.setId(2);
        c2.setName("Tablet");

        List<Category> cates = new ArrayList<>();
        cates.add(c1);
        cates.add(c2);

        return cates;
    }
}
