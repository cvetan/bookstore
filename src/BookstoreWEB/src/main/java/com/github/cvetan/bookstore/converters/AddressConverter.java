package com.github.cvetan.bookstore.converters;

import com.github.cvetan.bookstore.model.Address;
import com.github.cvetan.bookstore.sb.address.AddressSBLocal;
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
@FacesConverter (value = "addressConv")
@ManagedBean
public class AddressConverter implements Converter {
    
    @EJB
    private AddressSBLocal addressSB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && ! value.isEmpty()) {
            int id = Integer.parseInt(value);
            
            Address address = addressSB.getById(id);
            
            return address;
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && (value instanceof Address)) {
            Address address = (Address) value;
            
            return address.getId().toString();
        }
        
        return "";
    }
    
}
