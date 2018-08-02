package com.github.cvetan.bookstore.converters;

import com.github.cvetan.bookstore.model.Category;
import com.github.cvetan.bookstore.sb.category.CategorySBLocal;
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
@FacesConverter (value = "categoryConv")
@ManagedBean
public class CategoryConverter implements Converter {
    
    @EJB
    CategorySBLocal categorySB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && ! value.isEmpty()) {
            int id = Integer.parseInt(value);
            
            Category category = categorySB.getById(id);
            
            return category;
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && (value instanceof Category)) {
            Category category = (Category) value;
            
            return category.getId().toString();
        }
        
        return "";
    }
    
    
}
