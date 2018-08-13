package com.github.cvetan.bookstore.mb.author;

import com.github.cvetan.bookstore.model.Author;
import com.github.cvetan.bookstore.sb.author.AuthorSBLocal;
import com.github.cvetan.bookstore.sb.configuration.ConfigurationSBLocal;
import com.github.cvetan.bookstore.util.Redirector;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author cvetan
 */
@Named(value = "authorListMB")
@ViewScoped
public class AuthorListMB implements Serializable {
    
    @EJB
    private AuthorSBLocal authorSB;
    
    @EJB
    private ConfigurationSBLocal configurationSB;
    
    private List<Author> list;
    
    private int paginationLimit;
    
    private boolean selected;
    
    private Author selectedAuthor;
    
    private String message;

    /**
     * Creates a new instance of AuthorListMB
     */
    public AuthorListMB() {
    }

    public AuthorSBLocal getAuthorSB() {
        return authorSB;
    }

    public void setAuthorSB(AuthorSBLocal authorSB) {
        this.authorSB = authorSB;
    }

    public ConfigurationSBLocal getConfigurationSB() {
        return configurationSB;
    }

    public void setConfigurationSB(ConfigurationSBLocal configurationSB) {
        this.configurationSB = configurationSB;
    }

    public List<Author> getList() {
        return list;
    }

    public void setList(List<Author> list) {
        this.list = list;
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

    public Author getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(Author selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    @PostConstruct
    public void initPage() {
        list = authorSB.getList();
        paginationLimit = Integer.parseInt(configurationSB.getItem("backendPaginationLimit"));
        message = ResourceBundleLoader.loadFromClass("messages", "authorDeleted");
    }
    
    public void onRowSelect() {
        selected = true;
    }
    
    public void onRowUnselect() {
        selected = false;
    }
    
    public String openCreateForm() {
        return "/admin/author-form?faces-redirect=true";
    }
    
    public String openEditForm() {
        return "/admin/author-form?faces-redirect=true&" + selectedAuthor.getId();
    }
    
    public String delete() {
        try {
            authorSB.delete(selectedAuthor.getId());
            selected = false;
            list.remove(selectedAuthor);
            
            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/admin/author-list?faces-redirect=true");
            
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/admin/author-list?faces-redirect=true");
        }
    }
    
    
}
