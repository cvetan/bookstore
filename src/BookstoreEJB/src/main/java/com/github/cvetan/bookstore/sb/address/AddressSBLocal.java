package com.github.cvetan.bookstore.sb.address;

import com.github.cvetan.bookstore.model.Address;
import javax.ejb.Local;

/**
 *
 * @author cvetan
 */
@Local
public interface AddressSBLocal {
    
    public void save(Address address);
    
    public Address getById(int id);
    
}
