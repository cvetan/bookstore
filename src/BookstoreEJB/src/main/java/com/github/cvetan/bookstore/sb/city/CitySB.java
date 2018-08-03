package com.github.cvetan.bookstore.sb.city;

import com.github.cvetan.bookstore.model.City;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author cvetan
 */
@Stateless
public class CitySB extends BookstoreSB implements CitySBLocal {

    @Override
    public List<City> getList() {
        return entityManager.createNamedQuery("City.findAll").getResultList();
    }

    @Override
    public City getById(int id) {
        Query query = entityManager.createNamedQuery("City.findById");
        query.setParameter("id", id);
        
        City city = (City) query.getSingleResult();
        
        return city;
    }

    @Override
    public City getByPostalCode(String postalCode) {
        Query query = entityManager.createNamedQuery("City.findByPostalCode");
        query.setParameter("postalCode", postalCode);
        
        City city = (City) query.getSingleResult();
        
        return city;
    }
}
