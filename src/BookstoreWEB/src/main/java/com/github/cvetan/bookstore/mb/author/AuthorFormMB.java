package com.github.cvetan.bookstore.mb.author;

import static com.github.adminfaces.template.util.Assert.has;
import com.github.cvetan.bookstore.model.Author;
import com.github.cvetan.bookstore.sb.author.AuthorSBLocal;
import com.github.cvetan.bookstore.util.CloudinaryFacade;
import com.github.cvetan.bookstore.util.FileUploadUtil;
import com.github.cvetan.bookstore.util.FilesFacade;
import com.github.cvetan.bookstore.util.Redirector;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import java.io.File;
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
        try {
            File uploadedFile = FilesFacade.createTempFile(image.getInputstream(), image.getFileName());

            author.setImage(CloudinaryFacade.uploadAuthorImage(uploadedFile));
            author.setThumbnail(author.getImage());

            authorSB.save(author);

            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/admin/author-list?faces-redirect=true");
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/admin/author-form?faces-redirect=true");
        }
    }

    public String update() {
        try {
//            if (FileUploadUtil.uploaded(image)) {
//                File uploadedFile = FilesFacade.createTempFile(image.getInputstream(), image.getFileName());
//
//                author.setImage(CloudinaryFacade.uploadAuthorImage(uploadedFile));
//                author.setThumbnail(author.getImage());
//            }

            authorSB.update(author);

            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/admin/author-list?faces-redirect=true");
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/admin/author-form?faces-redirect=true&id=" + author.getId());
        }
    }

    public String close() {
        return "/admin/author-list?faces-redirect=true";
    }

}
