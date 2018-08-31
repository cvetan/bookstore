package com.github.cvetan.bookstore.sb.order;

import com.github.cvetan.bookstore.model.OrderE;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author cvetan
 */
@Stateless
public class OrderSB extends BookstoreSB implements OrderSBLocal {
    
    @Override
    public List<OrderE> getUnprocessedList() {
        return entityManager.createNamedQuery("OrderE.findAll").getResultList();
    }

    @Override
    public OrderE getById(int id) {
        OrderE order = entityManager.find(OrderE.class, id);
        
        return order;
    }

    @Override
    public void save(OrderE order) {
        entityManager.persist(order);
    }
}
