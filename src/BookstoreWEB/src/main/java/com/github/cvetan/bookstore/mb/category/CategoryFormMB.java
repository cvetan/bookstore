package com.github.cvetan.bookstore.mb.category;

import static com.github.adminfaces.template.util.Assert.has;
import com.github.cvetan.bookstore.model.Category;
import com.github.cvetan.bookstore.util.Redirector;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author cvetan
 */
@Named(value = "categoryFormMB")
@ViewScoped
public class CategoryFormMB extends CategoryMB implements Serializable {
    
    private String title;
    
    private String message;
    
    private Integer id;
    
    private Category category;
    
    private boolean editing;

    /**
     * Creates a new instance of CategoryFormMB
     */
    public CategoryFormMB() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }
    
    @PostConstruct
    public void initPage() {
        getData();
        
        if (has(id)) {
            title = ResourceBundleLoader.loadFromClass("titles", "editCategory");
            message = ResourceBundleLoader.loadFromClass("messages", "categoryUpdated");
            category = categorySB.getById(id);
            editing = true;
        } else {
            title = ResourceBundleLoader.loadFromClass("titles", "newCategory");
            message = ResourceBundleLoader.loadFromClass("messages", "categorySaved");
            category = new Category();
            editing = false;
        }
    }

    public String save() {
        try {
            categorySB.save(category);
            
            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/admin/category-list?faces-redirect=true");
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/admin/category-form?faces-redirect=true");
        }
    }
    
    public String update() {
        try {
            categorySB.update(category);
            
            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/admin/category-list?faces-redirect=true");
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/admin/category-form?faces-redirect=true");
        }
    }
    
    public String close() {
        return "/admin/category-list?faces-redirect=true";
    }
}
