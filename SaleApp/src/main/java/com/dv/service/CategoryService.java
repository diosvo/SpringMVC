package com.dv.service;

import com.dv.pojo.Category;
import java.util.List;

/**
 *
 * @author diosvo
 */
public interface CategoryService {

    List<Category> getCategories();

    Category getCategoryId(int id);
}
