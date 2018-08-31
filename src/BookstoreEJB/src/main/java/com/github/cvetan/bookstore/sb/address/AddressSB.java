package com.github.cvetan.bookstore.sb.address;

import com.github.cvetan.bookstore.model.Address;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import javax.ejb.Stateless;

/**
 *
 * @author cvetan
 */
@Stateless
public class AddressSB extends BookstoreSB implements AddressSBLocal {

    @Override
    public void save(Address address) {
        entityManager.persist(address);
    }

    @Override
    public Address getById(int id) {
        Address address = (Address) entityManager.find(Address.class, id);
        
        return address;
    }
}
