package com.github.cvetan.bookstore.mb;

import com.github.cvetan.bookstore.util.CloudinaryFacade;
import com.github.cvetan.bookstore.util.FilesFacade;
import com.github.cvetan.bookstore.util.Redirector;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author cvetan
 */
@Named(value = "uploadMB")
@ViewScoped
public class UploadMB implements Serializable {
    
    private UploadedFile file;

    /**
     * Creates a new instance of UploadMB
     */
    public UploadMB() {
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public String upload() {
        try {
            File uploadedFile = FilesFacade.createTempFile(file.getInputstream(), file.getFileName());
            
            String filename = CloudinaryFacade.uploadAuthorImage(uploadedFile);
            
            uploadedFile.delete();
            
            return Redirector.redirectWithMessage(filename, FacesMessage.SEVERITY_INFO, null);
        } catch (IOException ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, null);
        }
    }
    
}
