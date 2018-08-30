package com.github.cvetan.bookstore.mb.user;

import com.github.cvetan.bookstore.mb.session.UserSessionMB;
import com.github.cvetan.bookstore.model.User;
import com.github.cvetan.bookstore.sb.user.UserSBLocal;
import com.github.cvetan.bookstore.util.Redirector;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

/**
 *
 * @author cvetan
 */
@Named(value = "userRegisterMB")
@RequestScoped
public class UserRegisterMB {
    
    private String title;
    
    private String message;
    
    private User user;
    
    private String redirect;
    
    @Inject
    private UserSessionMB userSessionMB;
    
    @EJB
    private UserSBLocal userSB;

    /**
     * Creates a new instance of UserRegisterMB
     */
    public UserRegisterMB() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @PostConstruct
    public void initData() {
        title = ResourceBundleLoader.loadFromClass("titles", "userRegistration");
        message = ResourceBundleLoader.loadFromClass("messages", "registrationSuccessfull");
        redirect = "/index.xhtml?faces-redirect=true";
        user = new User();
    }
    
    public String register() {
        try {
            userSB.save(user);
            
            userSessionMB.setUser(user);
            
            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, redirect);
        } catch (Exception ex) {
            redirect = "/registration.xhtml?faces-redirect=true";
            
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, redirect);
        }
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
    
}
