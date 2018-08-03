package com.github.cvetan.bookstore.sb.city;

import com.github.cvetan.bookstore.model.City;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cvetan
 */
@Local
public interface CitySBLocal {
    
    public List<City> getList();
    
    public City getById(int id);
    
    public City getByPostalCode(String postalCode);
}
