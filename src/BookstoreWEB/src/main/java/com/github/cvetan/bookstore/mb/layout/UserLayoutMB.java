package com.github.cvetan.bookstore.mb.layout;

import com.github.cvetan.bookstore.model.Category;
import com.github.cvetan.bookstore.sb.category.CategorySBLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author cvetan
 */
@Named(value = "userLayoutMB")
@ApplicationScoped
public class UserLayoutMB {
    
    private List<Category> categories;
    
    @EJB
    private CategorySBLocal categorySB;

    /**
     * Creates a new instance of UserLayoutMB
     */
    public UserLayoutMB() {
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public CategorySBLocal getCategorySB() {
        return categorySB;
    }

    public void setCategorySB(CategorySBLocal categorySB) {
        this.categorySB = categorySB;
    }

    @PostConstruct
    public void getData() {
        categories = categorySB.getList();
    }
}
