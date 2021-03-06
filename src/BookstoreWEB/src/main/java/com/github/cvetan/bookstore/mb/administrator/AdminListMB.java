package com.github.cvetan.bookstore.mb.administrator;

import com.github.cvetan.bookstore.model.Administrator;
import com.github.cvetan.bookstore.sb.admin.AdministratorSBLocal;
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
@Named(value = "adminListMB")
@ViewScoped
public class AdminListMB implements Serializable {
    
    @EJB
    private AdministratorSBLocal administratorSB;
    
    @EJB
    private ConfigurationSBLocal configurationSB;
    
    private List<Administrator> list;
    
    private Administrator selectedAdministrator;
    
    private int paginationLimit;
    
    private boolean selected;

    /**
     * Creates a new instance of AdminListMB
     */
    public AdminListMB() {
    }

    public AdministratorSBLocal getAdministratorSB() {
        return administratorSB;
    }

    public void setAdministratorSB(AdministratorSBLocal administratorSB) {
        this.administratorSB = administratorSB;
    }

    public ConfigurationSBLocal getConfigurationSB() {
        return configurationSB;
    }

    public void setConfigurationSB(ConfigurationSBLocal configurationSB) {
        this.configurationSB = configurationSB;
    }

    public List<Administrator> getList() {
        return list;
    }

    public void setList(List<Administrator> list) {
        this.list = list;
    }

    public Administrator getSelectedAdministrator() {
        return selectedAdministrator;
    }

    public void setSelectedAdministrator(Administrator selectedAdministrator) {
        this.selectedAdministrator = selectedAdministrator;
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
    
    @PostConstruct
    public void initData() {
        list = administratorSB.getList();
        paginationLimit = Integer.parseInt(configurationSB.getItem("backendPaginationLimit"));
    }
    
    public String openCreateForm() {
        return "/admin/admin-form?faces-redirect=true";
    }
    
    public String openEditForm() {
        return "/admin/admin-form?faces-redirect=true&id=" + selectedAdministrator.getId();
    }
    
    public void delete() {
        try {
            administratorSB.delete(selectedAdministrator.getId());
            
            selected = false;
            
            list.remove(selectedAdministrator);
            
            String message = ResourceBundleLoader.loadFromClass("messages", "adminDeleted");
            
            Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/admin/admin-list?faces-redirect=true");
        } catch (Exception ex) {
            Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/admin/admin-list?faces-redirect=true");
        }
    }
    
    public void onRowSelect() {
        selected = true;
    }
    
}
