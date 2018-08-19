package com.github.cvetan.bookstore.mb.category;

import com.github.cvetan.bookstore.model.Category;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author cvetan
 */
public class CategoryListFormatter {
    
    public static void format(List<Category> rawList, List<Category> formatedList, int level) {
        for (Category c: rawList) {
            if (formatedList.contains(c)) {
                continue;
            }
            
            String name = String.join("", Collections.nCopies(level, " - "));
            
            name += c.getName();
            
            c.setName(name);
            
            formatedList.add(c);
            
            if ( ! c.getChildren().isEmpty()) {
                format(c.getChildren(), formatedList, level + 1);
            }
        }
    }
}
