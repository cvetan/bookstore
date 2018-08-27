package com.github.cvetan.bookstore.mb.book;

import static com.github.adminfaces.template.util.Assert.has;
import com.github.cvetan.bookstore.mb.category.CategoryListFormatter;
import com.github.cvetan.bookstore.model.Author;
import com.github.cvetan.bookstore.model.Book;
import com.github.cvetan.bookstore.model.Category;
import com.github.cvetan.bookstore.sb.author.AuthorSBLocal;
import com.github.cvetan.bookstore.sb.book.BookSBLocal;
import com.github.cvetan.bookstore.sb.category.CategorySBLocal;
import com.github.cvetan.bookstore.util.CloudinaryFacade;
import com.github.cvetan.bookstore.util.FileUploadUtil;
import com.github.cvetan.bookstore.util.Redirector;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
@Named(value = "bookFormMB")
@ViewScoped
public class BookFormMB implements Serializable {
    
    private String title;
    
    private Integer id;
    
    private boolean editing;
    
    private Book book;
    
    private String message;
    
    private List<Author> authorList;
    
    private List<Category> categoryList;
    
    @EJB
    private BookSBLocal bookSB;
    
    @EJB
    private CategorySBLocal categorySB;
    
    @EJB
    private AuthorSBLocal authorSB;
    
    private UploadedFile image;
    
    private UploadedFile sample;

    /**
     * Creates a new instance of BookFormMB
     */
    public BookFormMB() {
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
    
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public BookSBLocal getBookSB() {
        return bookSB;
    }

    public void setBookSB(BookSBLocal bookSB) {
        this.bookSB = bookSB;
    }

    public CategorySBLocal getCategorySB() {
        return categorySB;
    }

    public void setCategorySB(CategorySBLocal categorySB) {
        this.categorySB = categorySB;
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

    public UploadedFile getSample() {
        return sample;
    }

    public void setSample(UploadedFile sample) {
        this.sample = sample;
    }

    @PostConstruct
    public void initForm() {
        authorList = authorSB.getList();
        
        List<Category> rawList = categorySB.getList();
        categoryList = new ArrayList<>();
        
        CategoryListFormatter.format(rawList, categoryList, 0);
        
        if (has(id)) {
            title = ResourceBundleLoader.loadFromClass("titles", "editBook");
            editing = true;
            book = bookSB.getById(id);
            message = ResourceBundleLoader.loadFromClass("messages", "bookUpdated");
        } else {
            title = ResourceBundleLoader.loadFromClass("titles", "newBook");
            editing = false;
            book = new Book();
            message = ResourceBundleLoader.loadFromClass("messages", "bookSaved");
        }
    }
    
    public String save() {
        try {
            if (FileUploadUtil.uploaded(image)) {
                String filename = FileUploadUtil.generateFilename(book.getTitle());
                File file = FileUploadUtil.generateTempFile(image.getInputstream(), filename);
                
                Map result = CloudinaryFacade.getInstance().uploadBookImage(file);
                
                book.setImage((String) result.get("url"));
                book.setImagePublicId((String) result.get("public_id"));
            }
            
            bookSB.save(book);
            
            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/admin/book-list?faces-redirect=true");
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/admin/book-form?faces-redirect=true");
        }
    }
    
    public String update() {
        return "/admin/book-list?faces-redirect=true";
    }
    
    public String close() {
        
        return "/admin/book-list?faces-redirect=true";
    }
}
