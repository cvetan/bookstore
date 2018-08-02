package com.github.cvetan.bookstore.sb.category;

import com.github.cvetan.bookstore.exceptions.category.CategoryBookFKException;
import com.github.cvetan.bookstore.exceptions.category.CategoryParentFKException;
import com.github.cvetan.bookstore.model.Category;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

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
        entityManager.persist(category);
        
        clearCache();
    }

    @Override
    public void update(Category category) {
        entityManager.merge(category);
        
        clearCache();
    }

    @Override
    public Category getById(int id) {
        Query query = entityManager.createNamedQuery("Category.findById");
        query.setParameter("id", id);
        
        Category category = (Category) query.getSingleResult();
        
        return category;
    }

    @Override
    public void delete(int id) throws CategoryBookFKException, CategoryParentFKException {
        Category category = (Category) entityManager.find(Category.class, id);
        
        if ( ! category.getBookList().isEmpty()) {
            throw new CategoryBookFKException("categoryAssignedError");
        }
        
        if ( ! category.getChildren().isEmpty()) {
            throw new CategoryParentFKException("categoryHasSubcategoriesError");
        }
        
        entityManager.remove(category);
        
        clearCache();
    }
    
    
}
