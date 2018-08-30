package com.github.cvetan.bookstore.mb.session;

import com.github.cvetan.bookstore.model.User;
import com.github.cvetan.bookstore.sb.user.UserSBLocal;
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
@Named(value = "userSessionMB")
@SessionScoped
public class UserSessionMB implements Serializable {

    private String username;

    private String password;

    private User user;
    
    @EJB
    private UserSBLocal userSB;

    /**
     * Creates a new instance of UserSessionMB
     */
    public UserSessionMB() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String login() {
        String message = ResourceBundleLoader.loadFromClass("messages", "loginSuccessfull");
        String successUrl = "/index?faces-redirect=true";
        String failUrl = "/user-login?faces-redirect=true";

        try {
            user = userSB.login(username, password);
            
            username = null;
            password = null;
            
            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, successUrl);
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, failUrl);
        }
    }

    public String logout() {
        user = null;

        return "/index?faces-redirect=true";
    }

    public String profile() {
        return "/user-profile?faces-redirect=true";
    }
}
