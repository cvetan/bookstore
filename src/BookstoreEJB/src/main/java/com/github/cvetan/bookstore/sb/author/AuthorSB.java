package com.github.cvetan.bookstore.sb.author;

import com.github.cvetan.bookstore.exceptions.author.AuthorFKException;
import com.github.cvetan.bookstore.model.Author;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import com.github.cvetan.bookstore.util.SlugGenerator;
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
        List<String> slugList = entityManager.createNamedQuery("Author.getSluglist").getResultList();
        
        if (author.getSlug() == null) {
            author.setSlug(SlugGenerator.generateSlugRaw(author.getName(), slugList));
        } else {
            author.setSlug(SlugGenerator.generateSlug(author.getSlug(), slugList));
        }
        
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
