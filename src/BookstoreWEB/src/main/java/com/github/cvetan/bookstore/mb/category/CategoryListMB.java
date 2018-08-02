package com.github.cvetan.bookstore.mb.category;

import com.github.cvetan.bookstore.model.Category;
import com.github.cvetan.bookstore.sb.configuration.ConfigurationSBLocal;
import com.github.cvetan.bookstore.util.Redirector;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author cvetan
 */
@Named(value = "categoryListMB")
@ViewScoped
public class CategoryListMB extends CategoryMB implements Serializable {
    
    @EJB
    private ConfigurationSBLocal configurationSB;
    
    private int paginationLimit;
    
    private boolean selected;
    
    private Category selectedCategory;

    /**
     * Creates a new instance of CategoryListMB
     */
    public CategoryListMB() {
    }

    public ConfigurationSBLocal getConfigurationSB() {
        return configurationSB;
    }

    public void setConfigurationSB(ConfigurationSBLocal configurationSB) {
        this.configurationSB = configurationSB;
    }

    public int getPaginationLimit() {
        return paginationLimit;
    }

    public void setPaginationLimit(int paginationLimit) {
        this.paginationLimit = paginationLimit;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Category selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
    
    @PostConstruct
    public void initPage() {
        getData();
        
        paginationLimit = Integer.parseInt(configurationSB.getItem("backendPaginationLimit"));
    }
    
    public void onRowSelect() {
        selected = true;
    }

    public void onRowUnselect() {
        selected = false;
    }
    
    public String openCreateForm() {
        return "/admin/category-form?faces-redirect=true";
    }
    
    public String openEditForm() {
        return "/admin/category-form?faces-redirect=true&id=" + selectedCategory.getId();
    }
    
    public String delete() {
        try {
            categorySB.delete(selectedCategory.getId());
            selected = false;
            rawList.remove(selectedCategory);
            formatedList.remove(selectedCategory);
            
            String message = ResourceBundleLoader.loadFromClass("messages", "categoryDeleted");
            
            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/admin/category-list?faces-redirect=true");
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/admin/category-list?faces-redirect=true");
        }
    }
    
}
