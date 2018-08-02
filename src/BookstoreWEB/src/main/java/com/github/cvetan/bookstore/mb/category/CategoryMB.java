package com.github.cvetan.bookstore.mb.category;

import com.github.cvetan.bookstore.model.Category;
import com.github.cvetan.bookstore.sb.category.CategorySBLocal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author cvetan
 */
public class CategoryMB {
    
    @EJB
    protected CategorySBLocal categorySB;
    
    protected List<Category> rawList;
    
    protected List<Category> formatedList;

    public CategoryMB() {
    }
    
    public CategorySBLocal getCategorySB() {
        return categorySB;
    }

    public void setCategorySB(CategorySBLocal categorySB) {
        this.categorySB = categorySB;
    }

    public List<Category> getRawList() {
        return rawList;
    }

    public void setRawList(List<Category> rawList) {
        this.rawList = rawList;
    }

    public List<Category> getFormatedList() {
        return formatedList;
    }

    public void setFormatedList(List<Category> formatedList) {
        this.formatedList = formatedList;
    }
    
    protected void getData() {
        rawList = categorySB.getList();
        formatedList = new ArrayList<>();
        
        formatList(rawList, 0);
    }
    
    private void formatList(List<Category> rawList, int level) {
        for (Category c: rawList) {
            if (formatedList.contains(c)) {
                continue;
            }
            
            String name = String.join("", Collections.nCopies(level, " - "));
            
            name += c.getName();
            
            c.setName(name);
            
            formatedList.add(c);
            
            if ( ! c.getChildren().isEmpty()) {
                formatList(c.getChildren(), level + 1);
            }
        }
    }
}
