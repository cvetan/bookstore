package com.github.cvetan.bookstore.mb.session;

import com.github.cvetan.bookstore.model.Administrator;
import com.github.cvetan.bookstore.sb.admin.AdministratorSBLocal;
import com.github.cvetan.bookstore.util.Redirector;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

/**
 *
 * @author cvetan
 */
@Named(value = "adminSessionMB")
@SessionScoped
public class AdminSessionMB implements Serializable {

    @EJB
    private AdministratorSBLocal administratorSB;

    private String username;

    private String password;

    private Administrator administrator;

    /**
     * Creates a new instance of AdminSessionMB
     */
    public AdminSessionMB() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public String login() {
        String message = ResourceBundleLoader.loadFromClass("messages", "loginSuccessfull");
        String successUrl = "/admin/dashboard?faces-redirect=true";
        String failUrl = "/admin-login?faces-redirect=true";

        try {
            administrator = administratorSB.login(username, password);

            username = null;
            password = null;

            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, successUrl);

        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, failUrl);
        }
    }

    public String logout() {
        administrator = null;

        return "/admin-login?faces-redirect=true";
    }

}
