package com.github.cvetan.bookstore.sb.order;

import com.github.cvetan.bookstore.model.OrderE;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cvetan
 */
@Local
public interface OrderSBLocal {
    
    public List<OrderE> getUnprocessedList();
    
    public OrderE getById(int id);
    
    public void save(OrderE order);
}
