package com.github.cvetan.bookstore.exceptions.author;

import com.github.cvetan.bookstore.exceptions.BookstoreException;

/**
 *
 * @author cvetan
 */
public class AuthorFKException extends BookstoreException {
    
    public AuthorFKException(String message) {
        super(message);
    }
    
}
