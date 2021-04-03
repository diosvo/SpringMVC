package com.dv.repository.impl;

import com.dv.pojo.Category;
import com.dv.repository.CategoryRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author diosvo
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<Category> getCategories() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("from Category");
        return q.getResultList();
    }

    @Override
    @Transactional
    public Category getCategoryId(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Category.class, id);
    }
}
