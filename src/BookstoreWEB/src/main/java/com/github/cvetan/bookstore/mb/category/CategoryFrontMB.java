package com.github.cvetan.bookstore.mb.category;

import static com.github.adminfaces.template.util.Assert.has;
import com.github.cvetan.bookstore.model.Book;
import com.github.cvetan.bookstore.model.Category;
import com.github.cvetan.bookstore.sb.category.CategorySBLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author cvetan
 */
@Named(value = "categoryFrontMB")
@ViewScoped
public class CategoryFrontMB implements Serializable {
    
    private String title;
    
    private Integer id;
    
    private List<Book> bookList;
    
    private Category category;
    
    @EJB
    private CategorySBLocal categorySB;

    /**
     * Creates a new instance of CategoryFrontMB
     */
    public CategoryFrontMB() {
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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategorySBLocal getCategorySB() {
        return categorySB;
    }

    public void setCategorySB(CategorySBLocal categorySB) {
        this.categorySB = categorySB;
    }
    
    @PostConstruct
    public void initPage() {
        bookList = new ArrayList<>();
        
        if (has(id)) {
            category = categorySB.getById(id);
            
            for (Book b: category.getBookList()) {
                if (b.getActive()) {
                    bookList.add(b);
                }
            }
            
            title = category.getName();
        } 
    }
    
}
