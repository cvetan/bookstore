package com.github.cvetan.bookstore.mb.category;

import java.io.Serializable;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author cvetan
 */
@Named(value = "categoryFormMB")
@ViewScoped
public class CategoryFormMB extends CategoryMB implements Serializable {

    /**
     * Creates a new instance of CategoryFormMB
     */
    public CategoryFormMB() {
    }
    
}
