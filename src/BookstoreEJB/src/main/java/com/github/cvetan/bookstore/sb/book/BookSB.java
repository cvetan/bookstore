package com.github.cvetan.bookstore.sb.book;

import com.github.cvetan.bookstore.model.Book;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author cvetan
 */
@Stateless
public class BookSB extends BookstoreSB implements BookSBLocal {

    @Override
    public List<Book> getList() {
        return entityManager.createNamedQuery("Book.findAll").getResultList();
    }

    @Override
    public void save(Book book) {
        entityManager.persist(book);
        
        clearCache();
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
        
        clearCache();
    }

    @Override
    public void delete(int id) {
        Book book = (Book) entityManager.find(Book.class, id);
        
        // FK checks TODO
        
        entityManager.remove(book);
        
        clearCache();
    }

    @Override
    public Book getById(int id) {
        Book book = (Book) entityManager.find(Book.class, id);
        
        return book;
    }

    @Override
    public Book getBySlug(String slug) {
        Query query = entityManager.createNamedQuery("Book.findBySlug");
        query.setParameter("slug", slug);
        
        Book book = (Book) query.getSingleResult();
        
        return book;
    }
    
}
