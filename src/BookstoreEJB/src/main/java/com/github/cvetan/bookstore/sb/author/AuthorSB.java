package com.github.cvetan.bookstore.sb.author;

import com.github.cvetan.bookstore.exceptions.author.AuthorFKException;
import com.github.cvetan.bookstore.model.Author;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author cvetan
 */
@Stateless
public class AuthorSB extends BookstoreSB implements AuthorSBLocal {

    @Override
    public List<Author> getList() {
        return entityManager.createNamedQuery("Author.findAll").getResultList();
    }

    @Override
    public void save(Author author) {
        entityManager.persist(author);
        
        clearCache();
    }

    @Override
    public void update(Author author) {
        entityManager.merge(author);
        
        clearCache();
    }

    @Override
    public void delete(int id) throws AuthorFKException {
        Author author = (Author) entityManager.find(Author.class, id);
        
        if ( ! author.getBookList().isEmpty()) {
            throw new AuthorFKException("authorAssignedError");
        }
        
        entityManager.remove(author);
        
        clearCache();
    }

    @Override
    public Author getById(int id) {
        Query query = entityManager.createNamedQuery("Author.findById");
        query.setParameter("id", id);
        
        Author author = (Author) query.getSingleResult();
        
        return author;
    }
}
