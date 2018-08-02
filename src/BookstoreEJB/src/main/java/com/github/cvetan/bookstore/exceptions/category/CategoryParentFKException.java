package com.github.cvetan.bookstore.exceptions.category;

import com.github.cvetan.bookstore.exceptions.BookstoreException;

/**
 *
 * @author cvetan
 */
public class CategoryParentFKException extends BookstoreException {
    
    public CategoryParentFKException(String message) {
        super(message);
    }
   
}
