package com.github.cvetan.bookstore.converters;

import com.github.cvetan.bookstore.model.Author;
import com.github.cvetan.bookstore.sb.author.AuthorSBLocal;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cvetan
 */
@FacesConverter (value = "authorConv")
@javax.annotation.ManagedBean
public class AuthorConverter implements Converter {
    
    @EJB
    private AuthorSBLocal authorSB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && ! value.isEmpty()) {
            int id = Integer.parseInt(value);
            
            Author author = authorSB.getById(id);
            
            return author;
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && (value instanceof Author)) {
            Author author = (Author) value;
            
            return author.getId().toString();
        }
        
        return "";
    }
    
}
