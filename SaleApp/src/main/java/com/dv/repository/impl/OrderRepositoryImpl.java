package com.dv.repository.impl;

import com.dv.pojo.Cart;
import com.dv.pojo.SaleOrder;
import com.dv.pojo.SaleOrderDetails;
import com.dv.pojo.User;
import com.dv.repository.OrderRepository;
import com.dv.repository.ProductRepository;
import com.dv.utils.Utils;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author diosvo
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addOrder(Map<Integer, Cart> cart) {
        if (cart == null) {
            return false;
        }

        Session session = this.sessionFactory.getObject().getCurrentSession();
        Map<String, BigDecimal> stats = Utils.cartStats(cart);

        try {
            SaleOrder order = new SaleOrder();
            order.setUser(session.get(User.class, 6));
            order.setTotalAmount(stats.get("totalAmount"));
            session.save(order);

            for (Cart c : cart.values()) {
                SaleOrderDetails details = new SaleOrderDetails();
                details.setSaleOrder(order);
                details.setProduct(this.productRepository.getProductById(c.getProductId()));
                details.setUnitPrice(c.getPrice());
                details.setQuantiy(c.getQuantity());

                session.save(details);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Object[]> getStats(Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootOrder = query.from(SaleOrder.class);
        Root rootDetails = query.from(SaleOrderDetails.class);
        query = query.where(builder.equal(rootOrder.get("id"), rootDetails.get("id")));

        query.multiselect(rootOrder.get("id"),
                rootOrder.get("totalAmount").as(BigDecimal.class),
                rootOrder.get("createdDate").as(Date.class),
                builder.count(rootDetails.get("id")));

        query.groupBy(rootOrder.get("id"),
                rootOrder.get("totalAmount").as(BigDecimal.class),
                rootOrder.get("createdDate").as(Date.class));
        
        if(fromDate != null & toDate != null) {
            Predicate p1 = builder.greaterThanOrEqualTo(rootOrder.get("createdDate").as(Date.class), fromDate);
            Predicate p2 = builder.lessThanOrEqualTo(rootOrder.get("createdDate").as(Date.class), fromDate);
            
            query = query.having(p1, p2);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }
}
