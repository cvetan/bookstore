package com.github.cvetan.bookstore.sb.book;

import com.github.cvetan.bookstore.exceptions.book.BookIsbnUsedException;
import com.github.cvetan.bookstore.exceptions.book.BookOrderFKException;
import com.github.cvetan.bookstore.model.Book;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cvetan
 */
@Local
public interface BookSBLocal {
    
    public List<Book> getList();
    
    public void save(Book book) throws BookIsbnUsedException;
    
    public void update(Book book);
    
    public void delete(int id) throws BookOrderFKException;
    
    public Book getById(int id);
    
    public Book getBySlug(String slug);
}
