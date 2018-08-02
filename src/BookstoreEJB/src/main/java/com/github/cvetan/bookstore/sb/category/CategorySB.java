package com.github.cvetan.bookstore.sb.category;

import com.github.cvetan.bookstore.model.Category;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author cvetan
 */
@Stateless
public class CategorySB extends BookstoreSB implements CategorySBLocal {

    @Override
    public List<Category> getList() {
        return entityManager.createNamedQuery("Category.findAll").getResultList();
    }

    @Override
    public void save(Category category) {
        
    }

    @Override
    public void update(Category category) {
        
    }

    @Override
    public void getById(int id) {
        
    }

    @Override
    public void delete(int id) {
        
    }
    
    
}
