package com.github.cvetan.bookstore.converters;

import com.github.cvetan.bookstore.model.City;
import com.github.cvetan.bookstore.sb.city.CitySBLocal;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cvetan
 */
@FacesConverter (value = "cityConv")
@ManagedBean
public class CityConverter implements Converter {
    
    @EJB
    private CitySBLocal citySB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && ! value.isEmpty()) {
            int id = Integer.parseInt(value);
            
            City city = citySB.getById(id);
            
            return city;
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && (value instanceof City)) {
            City city = (City) value;
            
            return city.getId().toString();
        }
        
        return "";
    }
    
}
