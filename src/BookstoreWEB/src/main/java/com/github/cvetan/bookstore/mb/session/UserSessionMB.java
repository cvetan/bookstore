package com.github.cvetan.bookstore.mb.session;

import com.github.cvetan.bookstore.model.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

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
    
    public String logout() {
        user = null;
        
        return "/index?faces-redirect=true";
    }
    
    public String profile() {
        return "/user-profile?faces-redirect=true";
    }
}
