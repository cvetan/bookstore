package com.github.cvetan.bookstore.sb.author;

import com.github.cvetan.bookstore.exceptions.author.AuthorFKException;
import com.github.cvetan.bookstore.model.Author;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cvetan
 */
@Local
public interface AuthorSBLocal {
    
    public List<Author> getList();
    
    public void save(Author author);
    
    public void update(Author author);
    
    public void delete(int id) throws AuthorFKException;
    
    public Author getById(int id);
}
