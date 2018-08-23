package com.github.cvetan.bookstore.session.admin;

import com.github.cvetan.bookstore.exceptions.BookstoreException;

/**
 *
 * @author cvetan
 */
public class NoAccountException extends BookstoreException {
    
    public NoAccountException(String message) {
        super(message);
    }
    
}
