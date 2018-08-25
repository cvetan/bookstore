package com.github.cvetan.bookstore.exceptions.administrator;

import com.github.cvetan.bookstore.exceptions.BookstoreException;

/**
 *
 * @author cvetan
 */
public class AdministratorUsernameUsedException extends BookstoreException {
    
    public AdministratorUsernameUsedException(String message) {
        super(message);
    }
    
}
