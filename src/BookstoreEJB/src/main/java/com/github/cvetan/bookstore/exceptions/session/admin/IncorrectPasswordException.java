package com.github.cvetan.bookstore.exceptions.session.admin;

import com.github.cvetan.bookstore.exceptions.BookstoreException;

/**
 *
 * @author cvetan
 */
public class IncorrectPasswordException extends BookstoreException {
    
    public IncorrectPasswordException(String message) {
        super(message);
    }
    
}
