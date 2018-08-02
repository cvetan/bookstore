package com.github.cvetan.bookstore.mb.administrator;

import static com.github.adminfaces.template.util.Assert.has;
import com.github.cvetan.bookstore.model.Administrator;
import com.github.cvetan.bookstore.sb.admin.AdministratorSBLocal;
import com.github.cvetan.bookstore.util.Redirector;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author cvetan
 */
@Named(value = "adminFormMB")
@ViewScoped
public class AdminFormMB implements Serializable {
    
    private String title;
    
    private Integer id;
    
    private boolean editing;
    
    private Administrator administrator;
    
    private String message;
    
    @EJB
    private AdministratorSBLocal administratorSB;

    /**
     * Creates a new instance of AdminFormMB
     */
    public AdminFormMB() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AdministratorSBLocal getAdministratorSB() {
        return administratorSB;
    }

    public void setAdministratorSB(AdministratorSBLocal administratorSB) {
        this.administratorSB = administratorSB;
    }
    
    public void initForm() {
        if (has(id)) {
            title = ResourceBundleLoader.loadFromClass("titles", "editAdmin");
            editing = true;
            administrator = administratorSB.getById(id);
            message = ResourceBundleLoader.loadFromClass("messages", "adminUpdated");
        } else {
            title = ResourceBundleLoader.loadFromClass("titles", "newAdmin");
            editing = false;
            administrator = new Administrator();
            message = ResourceBundleLoader.loadFromClass("messages", "adminSaved");
        }
    }
    
    public String save() {
        try {
            administratorSB.save(administrator);

            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/admin/admin-list?faces-redirect=true");
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/admin/admin-form?faces-redirect=true");
        }
    }
    
    public String close() {
        return "/admin/admin-list?faces-redirect=true";
    }
    
    public String update() {
        try {
            administratorSB.update(administrator);
            
            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/admin/admin-list?faces-redirect=true");
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/admin/admin-list?faces-redirect=true");
        }
    }
}
