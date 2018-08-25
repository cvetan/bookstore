package com.github.cvetan.bookstore.exceptions.administrator;

import com.github.cvetan.bookstore.exceptions.BookstoreException;

/**
 *
 * @author cvetan
 */
public class AdministratorEmailUsedException extends BookstoreException {
    
    public AdministratorEmailUsedException(String message) {
        super(message);
    }
    
}
