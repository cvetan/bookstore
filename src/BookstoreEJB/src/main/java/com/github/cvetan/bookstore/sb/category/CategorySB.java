package com.github.cvetan.bookstore.sb.category;

import com.github.cvetan.bookstore.model.Category;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import java.util.ArrayList;
import java.util.Collections;
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
        List<Category> rawList = entityManager.createNamedQuery("Category.findAll").getResultList();
//        List<Category> formatedList = new ArrayList<>();
//        
//        formatList(rawList, formatedList, 0);
//        
//        return formatedList;
        return rawList;
    }
    
    private void formatList(List<Category> rawList, List<Category> formatedList, int level) {
        for (Category c: rawList) {
            if (formatedList.contains(c)) {
                continue;
            }
            
            c.setName(String.join("", Collections.nCopies(level, " - ")));
            
            formatedList.add(c);
            
            if ( ! c.getChildren().isEmpty()) {
                formatList(c.getChildren(), formatedList, level + 1);
            }
        }
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
