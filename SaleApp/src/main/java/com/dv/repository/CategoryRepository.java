package com.dv.repository;

import com.dv.pojo.Category;
import java.util.List;

/**
 *
 * @author diosvo
 */
public interface CategoryRepository {

    List<Category> getCategories();

    Category getCategoryId(int id);
}
