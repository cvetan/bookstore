package com.github.cvetan.bookstore.mb.book;

import com.github.cvetan.bookstore.model.Book;
import com.github.cvetan.bookstore.sb.book.BookSBLocal;
import com.github.cvetan.bookstore.sb.configuration.ConfigurationSBLocal;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author cvetan
 */
@Named(value = "bookListMB")
@ViewScoped
public class BookListMB implements Serializable {
    
    @EJB
    private BookSBLocal bookSB;
    
    @EJB
    private ConfigurationSBLocal configurationSB;
    
    private List<Book> list;
    
    private int paginationLimit;
    
    private boolean selected;
    
    private Book selectedBook;
    
    private String message;

    /**
     * Creates a new instance of BookListMB
     */
    public BookListMB() {
    }

    public BookSBLocal getBookSB() {
        return bookSB;
    }

    public void setBookSB(BookSBLocal bookSB) {
        this.bookSB = bookSB;
    }

    public ConfigurationSBLocal getConfigurationSB() {
        return configurationSB;
    }

    public void setConfigurationSB(ConfigurationSBLocal configurationSB) {
        this.configurationSB = configurationSB;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
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

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    @PostConstruct
    public void initPage() {
        list = bookSB.getList();
        paginationLimit = Integer.parseInt(configurationSB.getItem("backendPaginationLimit"));
        message = ResourceBundleLoader.loadFromClass("messages", "bookDeleted");
    }
    
    public void onRowSelect() {
        selected = true;
    }
    
    public void onRowUnselect() {
        selected = false;
    }
    
    public String openCreateForm() {
        return "/admin/book-form?faces-redirect=true";
    }
    
    public String openEditForm() {
        return "/admin/book-form?faces-redirect=true&id=" + selectedBook.getId();
    }
    
    public String delete() {
        
        return "/admin/book-list?faces-redirect=true";
    }
    
}
