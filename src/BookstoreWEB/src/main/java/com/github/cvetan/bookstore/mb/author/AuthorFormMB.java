package com.github.cvetan.bookstore.mb.author;

import static com.github.adminfaces.template.util.Assert.has;
import com.github.cvetan.bookstore.model.Author;
import com.github.cvetan.bookstore.sb.author.AuthorSBLocal;
import com.github.cvetan.bookstore.util.Redirector;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.UploadedFile;


/**
 *
 * @author cvetan
 */
@Named(value = "authorFormMB")
@ViewScoped
public class AuthorFormMB implements Serializable {
    
    private String title;
    
    private Integer id;
    
    private boolean editing;
    
    private Author author;
    
    private String message;
    
    @EJB
    private AuthorSBLocal authorSB;
    
    private UploadedFile image;

    /**
     * Creates a new instance of AuthorFormMB
     */
    public AuthorFormMB() {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthorSBLocal getAuthorSB() {
        return authorSB;
    }

    public void setAuthorSB(AuthorSBLocal authorSB) {
        this.authorSB = authorSB;
    }

    public UploadedFile getImage() {
        return image;
    }

    public void setImage(UploadedFile image) {
        this.image = image;
    }
    
    @PostConstruct
    public void initForm() {
        if (has(id)) {
            title = ResourceBundleLoader.loadFromClass("titles", "editAuthor");
            editing = true;
            author = authorSB.getById(id);
            message = ResourceBundleLoader.loadFromClass("messages", "authorUpdated");
        } else {
            title = ResourceBundleLoader.loadFromClass("titles", "newAuthor");
            editing = false;
            author = new Author();
            message = ResourceBundleLoader.loadFromClass("messages", "authorSaved");
        }
    }
    
    public String save() {
        
        return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, null);
    }
    
    public String update() {
        
        return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, null);
    }
    
    public String close() {
        return "/admin/author-list?faces-redirect=true";
    }
    
}
