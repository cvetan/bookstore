package com.github.cvetan.bookstore.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author cvetan
 */
public class Redirector {
    
    public static String redirectWithMessage(String message, FacesMessage.Severity severity, String location) {
        composeMessage(message, severity);
        
        return location;
    }
    
    private static void composeMessage(String message, FacesMessage.Severity severity) {
        FacesContext context = FacesContext.getCurrentInstance();
        Flash flash = context.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        
        context.addMessage(null, new FacesMessage(severity, null, message));
        
        
    }
}
