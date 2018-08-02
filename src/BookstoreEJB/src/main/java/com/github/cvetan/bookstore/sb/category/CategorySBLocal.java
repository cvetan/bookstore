package com.github.cvetan.bookstore.sb.category;

import com.github.cvetan.bookstore.model.Category;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cvetan
 */
@Local
public interface CategorySBLocal {
    
    public List<Category> getList();
    
    public void save(Category category);
    
    public void update(Category category);
    
    public void getById(int id);
    
    public void delete(int id);
    
    
    
}
